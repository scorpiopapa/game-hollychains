package com.bt.chains.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bt.chains.bean.domain.RoleUpgradeConfig;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserRole;
import com.bt.chains.bean.form.BuyUserRoleForm;
import com.bt.chains.bean.form.IntensifyUserRoleForm;
import com.bt.chains.bean.form.UserRoleForm;
import com.bt.chains.bean.view.Item;
import com.bt.chains.bean.view.MoneyView;
import com.bt.chains.bean.view.UpdateItemView;
import com.bt.chains.constant.Constants;
import com.bt.chains.constant.DBConstants;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.mapper.RoleMapper;
import com.bt.chains.mapper.UserMapper;

@Service
public class RoleService {
	private final static Logger log = LoggerFactory.getLogger(RoleService.class);
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ValidationService validationService;
	
	@Transactional(rollbackFor=Exception.class)
	public UpdateItemView saveUserRole(UserRoleForm form){
		int userId = form.getUserId();
		int roleId = form.getRoleId();
		
		UserRole userRole = roleMapper.queryRole(userId, roleId, null);
		userRole.setInUse(DBConstants.InUseStatus.InUse);
		
		roleMapper.resetUserRoleInUseStatus(userId, DBConstants.InUseStatus.NotInUse);
		roleMapper.updateUserRole(userRole);
		
		UpdateItemView view = new UpdateItemView();
		List<Item> items = new ArrayList<>();
		items.add(new Item(userRole.getRoleId(), userRole.getRoleRank()));
		view.setItems(items);
		
		return view;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int buyUserRole(BuyUserRoleForm form) {
		List<UserRole> roles = form.getRoles();
		if(roles != null && roles.size() > 0){
			int userId = form.getUserId();
			int money = form.getMoney();
			String payType = form.getPayType();
			User user = new User();
			user.setUserId(userId);
			if("0".equals(payType)){
				user.setMoney(money);
				userMapper.updateUserMoney(user);
			}else if("1".equals(payType)){
				user.setSpecialMoney(money);
				userMapper.updateUserSpecialMoney(user);
			}
			
			//添加用户职业
			Iterator<UserRole> iterator = roles.iterator();
			while(iterator.hasNext()){
				UserRole userRole = iterator.next();
				userRole.setUserId(userId);
				roleMapper.insertUserRole(userRole);
			}
		}else{
			return 0;
		}
		return 1;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public MoneyView intensifyUserRole(IntensifyUserRoleForm form) throws RequestException{
		MoneyView moneyView = new MoneyView();
		int status = 0;
		int userId = form.getUserId();
		int roleId = form.getRoleId();
		
		//查询用户是否含有该职业
		log.debug("select user role");
		UserRole ur = roleMapper.queryRole(userId, roleId, null);
		if(ur == null){
			log.debug("do unlock");
			//查询该职业的解锁付费币数量
			RoleUpgradeConfig roleUpgradeConfig = roleMapper.selectRoleUpgradeConfig(roleId, 0);
			if(roleUpgradeConfig != null){
				int unlockGold = roleUpgradeConfig.getSpecialMoney();
				if(unlockGold > 0){
					//检验用户付费币是否充足
					validationService.validateGem(userId, unlockGold);
					
					//扣除用户付费币
					log.debug("update gem");
					User user = new User();
					user.setUserId(userId);
					user.setSpecialMoney(unlockGold);
					userMapper.updateUserSpecialMoney(user);
					
					//添加用户职业
					UserRole role = new UserRole();
					role.setUserId(userId);
					role.setRoleId(roleId);
					role.setRoleRank(1);
					userMapper.insertUserRole(role);
				}else{
					throw new RequestException(ErrorCodeConstants.NO_DATA_ERROR, ErrorCodeConstants.NO_DATA_MSG);
				}
			}else{
				throw new RequestException(ErrorCodeConstants.NO_DATA_ERROR, ErrorCodeConstants.NO_DATA_MSG);
			}
		}else{
			log.debug("do upgrade");
			//升级
			User user = userMapper.selectUser(userId);
			UserRole userRole = roleMapper.queryRole(userId, roleId, null);
			if(userRole == null){
//				return Integer.valueOf(ErrorCodeConstants.ROLE_NO_EXISTS);
				throw new RequestException(ErrorCodeConstants.ROLE_NO_EXISTS, ErrorCodeConstants.ROLE_NO_EXISTS_MSG);
			}
			
			RoleUpgradeConfig config = roleMapper.selectRoleUpgradeConfig(roleId, userRole.getRoleRank());
			
			if(config.getMoney() == 0 && config.getSpecialMoney() == 0){
				// 职业已经达到上限，不能继续升级
				throw new RequestException(ErrorCodeConstants.ROLE_MAX, ErrorCodeConstants.ROLE_MAX_MSG);
			}
			
			int balance = ServiceHelper.calculateBalance(user, userId, form.getPayType(), config.getMoney(), config.getSpecialMoney());
			
			if(balance < 0 ){
//				return Integer.valueOf(ErrorCodeConstants.NOT_ENOUGH_MONEY);
				throw new RequestException(ErrorCodeConstants.NOT_ENOUGH_MONEY, ErrorCodeConstants.NOT_ENOUGH_MONEY_MSG);
			}
			
			if(Constants.PaymentType.PayCoin == form.getPayType()){
				user.setSpecialMoney(balance);
			}else{
				user.setMoney(balance);
			}
			
			userMapper.updateUser(user);
			
			//更新用户级别
			userRole.setRoleRank(userRole.getRoleRank() + 1);
			roleMapper.updateUserRole(userRole);
		}
		
		User u = userMapper.queryUserByUserId(userId);
		moneyView.setMoney(u.getMoney());
		moneyView.setSpecialMoney(u.getSpecialMoney());
		return moneyView;
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED) 
	public List<UserRole> getUserRoles(int userId){
		return roleMapper.queryAllRole(userId);
	}
}
