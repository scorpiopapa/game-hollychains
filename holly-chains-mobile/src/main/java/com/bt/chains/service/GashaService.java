package com.bt.chains.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.GashaWeapon;
import com.bt.chains.bean.domain.GashaWeaponHis;
import com.bt.chains.bean.domain.Param;
import com.bt.chains.bean.domain.ProductConfig;
import com.bt.chains.bean.domain.Prop;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserProp;
import com.bt.chains.bean.domain.UserRole;
import com.bt.chains.bean.domain.UserWeapon;
import com.bt.chains.bean.domain.Weapon;
import com.bt.chains.bean.form.BuyWeaponForm;
import com.bt.chains.bean.form.GashaForm;
import com.bt.chains.bean.view.BuyWeaponView;
import com.bt.chains.bean.view.ShopWeaponMenu;
import com.bt.chains.bean.view.WeaponConfigView;
import com.bt.chains.constant.DBConstants;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.constant.DBConstants.RewardType;
import com.bt.chains.exception.RequestException;
import com.bt.chains.mapper.GashaMapper;
import com.bt.chains.mapper.UserMapper;
import com.bt.chains.mapper.WeaponMapper;

@Service
public class GashaService {
	private final static Logger log = LoggerFactory
			.getLogger(GashaService.class);

	@Autowired
	private GashaMapper gashaMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RewardService rewardService;
	
	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private WeaponMapper weaponMapper;
	
	@Autowired
	private GameSettingRepository gameSettingRepository;
	
	@Autowired
	private NoviceNavigationService noviceNavigationService;

	@Transactional(rollbackFor = Exception.class)
	public int getGashaCounts(int userId) {
		// 查询是否有扭蛋券
		UserProp userProp = gashaMapper.selectGashaCounts(userId);
		if (userProp != null) {
			return userProp.getPropNum();
		}
		return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	public List<WeaponConfigView> getWeaponByGashas(GashaForm form) {
		List<WeaponConfigView> weaponConfigViews;
		// 根据数量获取随机扭蛋信息
		weaponConfigViews = getRandomWeapons(form.getGetGashaNum());
		if (getGashaCounts(form.getUserId()) != 0) {
			// 更新用户扭蛋券数量
			gashaMapper.updateGashaNum(form);
		}
		// 添加扭蛋历史信息
		for (WeaponConfigView weaponConfigView : weaponConfigViews) {
			GashaWeaponHis weaponHis = new GashaWeaponHis();
			weaponHis.setUserId(form.getUserId());
			weaponHis.setWeaponId(weaponConfigView.getWeaponId());
			gashaMapper.insertWeaponConfig(form);
		}
		return weaponConfigViews;
	}

	@Transactional(rollbackFor = Exception.class)
	public int buyGasha(GashaForm form) {
		if (getGashaCounts(form.getUserId()) != 0) {
			// 更新用户扭蛋券次数
			gashaMapper.updateGashaAddNum(form);
		} else {
			// 添加用户扭蛋券次数
			gashaMapper.insertGasha(form);
		}
		if ("0".equals(form.getBuyGashaType())) {// 如果是扭蛋券购买
			gashaMapper.updateWeaponNum(form);
		} else if ("1".equals(form.getBuyGashaType())) {// 如果是钻石购买
			// 更新用户金币数量
			User user = new User();
			user.setUserId(form.getUserId());
			user.setSpecialMoney(form.getSpecialMoney());
			userMapper.updateUserSpecialMoney(user);

			// 更新“挖金者”信息
			rewardService.processRewardStatus(form.getUserId(),
					RewardType.SpecialMoneySum, form.getSpecialMoney());
		}
		return 1;
	}
	
//	@Transactional(rollbackFor=Exception.class)
//	public  int buyGasha(GashaForm form){
//		if(getGashaCounts(form.getUserId()) != 0){
//			//更新用户扭蛋券次数
//			gashaMapper.updateGashaAddNum(form);
//		}else{
//			//添加用户扭蛋券次数
//			gashaMapper.insertGasha(form);
//		}
//		if("0".equals(form.getBuyGashaType())){//如果是扭蛋券购买
//			gashaMapper.updateWeaponNum(form);
//		}else if("1".equals(form.getBuyGashaType())){//如果是钻石购买
//			//更新用户金币数量
//			User user = new User();
//			user.setUserId(form.getUserId());
//			user.setSpecialMoney(form.getSpecialMoney());
//			userMapper.updateUserSpecialMoney(user);
//			
//			//更新“挖金者”信息
//			rewardService.processRewardStatus(form.getUserId(), RewardType.SpecialMoneySum, form.getSpecialMoney());
//		}
//		return 1;
//	}

//	@Transactional(rollbackFor = Exception.class)
//	public int buyGashaSpecialRole(GashaForm form) {
//		// 商人职业，可 替换
//		int specialrole = 10;
//		int userId = form.getUserId();
//		User userInfo = userMapper.queryUserByUserId(userId);
//		int leftMoney = 0;
//		if (userInfo != null) {
//			leftMoney = userInfo.getMoney();
//		}
//		// 查询商人职业的解锁配置的金币
//		int roleCost = gashaMapper.getGaShaRoleConfig(specialrole);
//		if (leftMoney >= roleCost) {
//			// 查询当前 用户是否存在商人职业
//			List<UserRole> userroles = userMapper.selectJobs(userId);
//			boolean existingflg = false;
//			if (!CollectionUtils.isEmpty(userroles)) {
//				for (UserRole role : userroles) {
//					if (role.getRoleId() == specialrole) {
//						existingflg = true;
//						break;
//					}
//				}
//			}
//			if (!existingflg) {
//				UserRole roleobj = new UserRole();
//				roleobj.setIsNewRole(0);
//				roleobj.setRoleId(specialrole);
//				roleobj.setRoleRank(2);
//				roleobj.setUserId(userId);
//				userMapper.insertUserRole(roleobj);
//			}
//			// TODO 返回数据格式待修改根据需要
//			return 0;
//		} else {
//			// 余额不足，防止外挂
//			return 1;
//		}
//	}

	@Transactional(rollbackFor = Exception.class)
	public List<WeaponConfigView> getRandomWeapons(int getNum) {
		List<WeaponConfigView> weaponConfigViews = gashaMapper
				.getWeaponConfig();
		int totalWeight = 0;
		for (WeaponConfigView weaponConfigView : weaponConfigViews) {
			totalWeight += weaponConfigView.getWeight();
		}
		List<WeaponConfigView> randomWeapons = new ArrayList<WeaponConfigView>();
		do {
			int weight = (int) (totalWeight * Math.random());
			int curWeight = 0;
			for (WeaponConfigView weaponConfigView : weaponConfigViews) {
				curWeight += weaponConfigView.getWeight();
				if (curWeight >= weight) {
					randomWeapons.add(weaponConfigView);
					break;
				}
			}
		} while (randomWeapons.size() < getNum);
		return randomWeapons;
	}

	/**
	 * 
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public List<ShopWeaponMenu> getWeaponPurchase() {
		List<ShopWeaponMenu> wepaonpurchaseInfolist = gashaMapper
				.getWeaponPurchase(null);
		return wepaonpurchaseInfolist;
	}
	/**
	 * 购买武器
	 */
	@Transactional(rollbackFor = Exception.class)
	public BuyWeaponView buyWeapon(BuyWeaponForm form) throws RequestException{
		BuyWeaponView view = new BuyWeaponView();
		int gashaId = form.getGashaId();
		int userId = form.getUserId();
		String buyType = form.getBuyType();
		
		int ticket = 0, gainWeaponCount = 0, specialMoney = 0;
		List<ShopWeaponMenu> list = gashaMapper.getWeaponPurchase(gashaId);
		if(list.size() > 0){
			ShopWeaponMenu shopWeaponMenu = list.get(0);
			ticket = shopWeaponMenu.getTicket();
			specialMoney = shopWeaponMenu.getSpecialMoney();
			gainWeaponCount = shopWeaponMenu.getGainWeaponCount();
			
			// 钻石购买
			if ("G".equals(buyType)) {
				log.debug("check gem is or no enough");
				//判断宝石是否充足
				validationService.validateGem(userId, specialMoney);
				
				//更新用户宝石数量
				log.debug("update gem");
				User user = new User();
				user.setUserId(userId);
				user.setSpecialMoney(specialMoney);
				userMapper.updateUserSpecialMoney(user);
			}
			// 武器制造券购买
			else {
				log.debug("check weapon securities is or no enough");
				validationService.validateWeaponSecurities(userId, ticket);
				
				UserProp userProp = userMapper.queryUserPropByType(userId, DBConstants.UserProp.GashaTicket);
				userProp.setPropNum(-ticket);
				//扣除用户武器制造券
				log.debug("update weapon");
				userMapper.updateUserProp(userProp);
			}
			
			List<WeaponConfigView> weaponList = getRandomWeapons(gainWeaponCount);
			
			if(weaponList != null && weaponList.size() > 0){
				//武器个数
				int weaponCount = weaponList.size();
				//判断用户背包容量
				int bagCount = userMapper.selectStoreCount(userId, 1);
				//判断武器仓库容量
				int storeCount = userMapper.selectStoreCount(userId, 0);
				//用户道具背包容量
				int bagMaxCount = 0;
				UserProp prop1 = userMapper.queryUserPropByType(userId, DBConstants.UserProp.Bag);
				if(prop1 != null){
					bagMaxCount = userMapper.queryUserPropNum(userId, DBConstants.UserProp.Bag + "");
				}else{
					bagMaxCount = gameSettingRepository.getInt(GameSettingRepository.USER_BAG);
				}
				//用户当前武器仓库容量
				int storeMaxCount = 0;
				UserProp prop2 = userMapper.queryUserPropByType(userId, DBConstants.UserProp.WeaponRepository);
				if(prop2 != null){
					storeMaxCount = userMapper.queryUserPropNum(userId, DBConstants.UserProp.WeaponRepository + "");;
				}else{
					storeMaxCount = gameSettingRepository.getInt(GameSettingRepository.USER_STORE);
				}
				//背包剩余容量
				int bagSurplusCount = bagMaxCount - bagCount;
				//仓库剩余容量
				int storeSurplusCount = storeMaxCount - storeCount;

				List<GashaWeapon> gashaWeapons = null;
				//如果背包容量够大
				log.debug("save user weapon");
				if(bagSurplusCount >= weaponCount){
					//返回武器数据
					log.debug("query weapon wids");
					gashaWeapons = new ArrayList<GashaWeapon>();
					for(int i = 0; i < weaponCount; i++){
						//查询武器WID
						int wId = weaponMapper.queryWeaponWID(weaponList.get(i).getWeaponId());
						//查询武器是否为新武器
						int status = weaponMapper.queryWeaponCount(userId, weaponList.get(i).getWeaponId()) > 0 ? 0 : 1;
						GashaWeapon gashaWeapon = new GashaWeapon();
						gashaWeapon.setwId(wId);
						gashaWeapon.setStatus(status);
						gashaWeapons.add(gashaWeapon);
						
						UserWeapon userWeapon = new UserWeapon();
						userWeapon.setUserId(userId);
						userWeapon.setWeaponId(weaponList.get(i).getWeaponId());
						userWeapon.setWeaponRank(1);
						userWeapon.setBagStatus(1);
						weaponMapper.insertUserWeapon(userWeapon);
					}
				}else{
					//如果背包剩余容量和仓库剩余容量之和大于所获得的武器个数
					if((bagSurplusCount + storeSurplusCount) >= weaponCount){
						//返回武器数据
						log.debug("query weapon wids");
						gashaWeapons = new ArrayList<GashaWeapon>();
						if(bagSurplusCount > 0){
							for(int i = 0; i < weaponCount; i++){
								//查询武器WID
								int wId = weaponMapper.queryWeaponWID(weaponList.get(i).getWeaponId());
								//查询武器是否为新武器
								int status = weaponMapper.queryWeaponCount(userId, weaponList.get(i).getWeaponId()) > 0 ? 0 : 1;
								GashaWeapon gashaWeapon = new GashaWeapon();
								gashaWeapon.setwId(wId);
								gashaWeapon.setStatus(status);
								gashaWeapons.add(gashaWeapon);
								
								UserWeapon userWeapon = new UserWeapon();
								userWeapon.setUserId(userId);
								userWeapon.setWeaponId(weaponList.get(i).getWeaponId());
								userWeapon.setWeaponRank(1);
								if(i < bagSurplusCount){
									userWeapon.setBagStatus(1);
								}else{
									userWeapon.setBagStatus(0);
								}
								weaponMapper.insertUserWeapon(userWeapon);
							}
						}else{
							for(int i = 0; i < weaponCount; i++){
								//查询武器WID
								int wId = weaponMapper.queryWeaponWID(weaponList.get(i).getWeaponId());
								//查询武器是否为新武器
								int status = weaponMapper.queryWeaponCount(userId, weaponList.get(i).getWeaponId()) > 0 ? 0 : 1;
								GashaWeapon gashaWeapon = new GashaWeapon();
								gashaWeapon.setwId(wId);
								gashaWeapon.setStatus(status);
								gashaWeapons.add(gashaWeapon);
								
								UserWeapon userWeapon = new UserWeapon();
								userWeapon.setUserId(userId);
								userWeapon.setWeaponId(weaponList.get(i).getWeaponId());
								userWeapon.setWeaponRank(1);
								userWeapon.setBagStatus(0);
								weaponMapper.insertUserWeapon(userWeapon);
							}
						}
					}else{
						throw new RequestException(ErrorCodeConstants.NOT_ENOUGH_STROE_ERROR, ErrorCodeConstants.NOT_ENOUGH_STROE_MSG);
					}
				}
				
				
				//返回当前用户剩余金币和钻石
				log.debug("query money and gem");
				User user = userMapper.selectUser(userId);
				int money = user.getMoney();
				int gem = user.getSpecialMoney();
				
				view.setGashaWeapons(gashaWeapons);
				view.setMoney(money);
				view.setSpecialMoney(gem);
				
			}else{
				throw new RequestException(ErrorCodeConstants.BUY_WEAPON_ERROR, ErrorCodeConstants.BUY_WEAPON_MSG);
			}
		}else{
			throw new RequestException(ErrorCodeConstants.GACHA_ID_ERROR, ErrorCodeConstants.GACHA_ID_ERROR_MSG);
		}
		
		return view;
	}
	
	public List<ShopWeaponMenu> getShopWeaponMenu(){
		return gashaMapper.getWeaponPurchase(null);
	}
}
