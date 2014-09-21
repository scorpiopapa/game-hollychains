package com.bt.chains.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bt.chains.bean.domain.Param;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserProp;
import com.bt.chains.bean.domain.UserWeapon;
import com.bt.chains.bean.domain.UserWeaponUpgradeParam;
import com.bt.chains.bean.domain.Weapon;
import com.bt.chains.bean.domain.WeaponInfoView;
import com.bt.chains.bean.form.IntensifyUserWeaponForm;
import com.bt.chains.bean.form.SacrifiedWeapon;
import com.bt.chains.bean.form.WeaponComposeForm;
import com.bt.chains.bean.form.WeaponForm;
import com.bt.chains.bean.form.WeaponImportForm;
import com.bt.chains.bean.form.WeaponSellForm;
import com.bt.chains.bean.view.ComposedWeaponView;
import com.bt.chains.bean.view.IntensifyUserWeaponView;
import com.bt.chains.bean.view.Item;
import com.bt.chains.bean.view.UpdateItemView;
import com.bt.chains.bean.view.WeaponView;
import com.bt.chains.constant.DBConstants;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.constant.DBConstants.RewardType;
import com.bt.chains.exception.RequestException;
import com.bt.chains.mapper.UserMapper;
import com.bt.chains.mapper.WeaponMapper;

@Service
public class WeaponService {
	private final static Logger log = LoggerFactory.getLogger(WeaponService.class);
	
	@Autowired
	private WeaponMapper weaponMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RewardService rewardService;
	
	@Transactional(rollbackFor=Exception.class)
	public ComposedWeaponView composeWeapon(WeaponComposeForm form) throws RequestException{
		int userId = form.getUserId();
		
		List<SacrifiedWeapon> weapons = form.getSacrifiedWeapons();
		List<Integer> list = new ArrayList<Integer>();
		Iterator<SacrifiedWeapon> iterator = weapons.iterator();
		
		//计算需要扣除贡品的硬币数
		int count = weapons.size();
		int money = count * DBConstants.Weapon.ComposeWeaponMoney;
		User u = userMapper.selectUser(userId);
		int uMoney = u.getMoney();
		if(money > uMoney){
			throw new RequestException(ErrorCodeConstants.NOT_ENOUGH_MONEY, ErrorCodeConstants.NOT_ENOUGH_MONEY_MSG);
		}
		u.setUserId(userId);
		u.setMoney(money);
		userMapper.updateUserMoney(u);
		int specialMoney = u.getSpecialMoney();
		int calcMoney = uMoney - money;
		
		
		int points = 0;
		List<UserWeaponUpgradeParam> params = userMapper.selectUserWeaponUpgradeParams();
		while(iterator.hasNext()){
			SacrifiedWeapon sw = iterator.next();
			
			// 计算贡品转化的经验值
			points += calculatePoints(sw, params);
			list.add(sw.getId());
		}
		log.info("sacrified weapons points is {}", points);
		
		User user = new User();
		user.setWeaponIds(list);
		user.setUserId(userId);
		
		//删除武器贡品
		weaponMapper.deleteWeapon(user);
		
		//更新新武器的级别
		UserWeapon userWeapon = userMapper.selectWeapons(null, form.getId()).get(0);
		int weaponRank = userWeapon.getWeaponRank();
		log.info("before compose weapon rank is {}", weaponRank);
		
		int curPoint = userWeapon.getPoint();
		log.info("curent point is {}", curPoint);
		
		points += curPoint;
//		int weaponPoint = points;	// 武器当前经验值
		for(int i = params.size() - 1; i >= 0; i--){
			UserWeaponUpgradeParam param = params.get(i);
			if(points >= param.getBenchmarkPoint()){
				weaponRank = param.getLevel();
//				points -= param.getBenchmarkPoint();
				break;
			}
		}
		
		userWeapon.setWeaponRank(weaponRank);
		userWeapon.setPoint(points);
		weaponMapper.updateUserWeapon(userWeapon);
		
		ComposedWeaponView view = new ComposedWeaponView();
		view.setRank(weaponRank);
		view.setPoints(points);
		view.setMoneyBalance(specialMoney);
		view.setGemBanlance(calcMoney);
		
		return view;
	}
	
	int calculatePoints(SacrifiedWeapon weapon, List<UserWeaponUpgradeParam> params){
		int weaponId = userMapper.selectWeapons(null, weapon.getId()).get(0).getWeaponId();
		log.info("sacrified weapon wid {}, weaponId {}", weapon.getId(), weaponId);
		
		Weapon w = weaponMapper.queryWeaponBaseData(null, weaponId, null).get(0);
		int points = w.getBaseExperience();

		for(UserWeaponUpgradeParam param : params){
			if(weapon.getRank() == param.getLevel()){
				points += param.getConvertPoint();
				break;
			}
		}
		
		return points;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int sellWeapon(WeaponSellForm form){
		int userId = form.getUserId();
		List<Param> ids = form.getIds();
		List<Integer> weaponSellIds = new ArrayList<Integer>();
		Iterator<Param> iterator = ids.iterator(); 
		while(iterator.hasNext()){
			weaponSellIds.add(iterator.next().getId());
		}
		
		//计算武器可以卖掉的金币数
		//获取wid
		List<Param> wids = weaponMapper.queryUserWeaponWids(userId, weaponSellIds);
		Iterator<Param> it = wids.iterator(); 
		int sellCount = 0;
		while(it.hasNext()){
			sellCount += weaponMapper.selectWeaponSellPrice(null, it.next().getId());
		}
		
		User user = new User();
		user.setWeaponIds(weaponSellIds);
		user.setUserId(userId);
		
		//删除买掉的武器
		weaponMapper.deleteWeapon(user);
		
		//更新用户金币数量
		user.setMoney(sellCount);
		weaponMapper.updateUserGold(user);
		
		//更新“赏金猎人”信息
		rewardService.processRewardStatus(form.getUserId(), RewardType.MoneySum, sellCount);
		return 0;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public WeaponView importWeapon(WeaponImportForm form) throws RequestException{
		int userId = form.getUserId();
		List<Param> weaponIds = form.getIds();
		int weaponCount = weaponIds.size();
		//判断背包数量是否充足
		int bagCount = userMapper.selectStoreCount(userId, DBConstants.User.bagStatus);
		//查询用户背包的容量
		int bagMaxCount = userMapper.queryUserPropNum(userId, DBConstants.UserProp.Bag+"");
		if((weaponCount + bagCount) > bagMaxCount){
			throw new RequestException(ErrorCodeConstants.NOT_ENOUGH_BAG_ERROR, ErrorCodeConstants.NOT_ENOUGH_BAG_MSG);
		}
		
		List<Integer> weaponImportIds = new ArrayList<Integer>();
		Iterator<Param> iterator = weaponIds.iterator();
		while(iterator.hasNext()){
			weaponImportIds.add(iterator.next().getId());
		}
		
		User user = new User();
		user.setUserId(userId);
		user.setWeaponIds(weaponImportIds);
		
		weaponMapper.updateUserBagWeapon(user);
		
		WeaponView weaponView = new WeaponView();
		List<UserWeapon> weapons = userMapper.selectWeapons(userId, null);
		weaponView.setUserId(userId);
		weaponView.setWeapons(weapons);
		return weaponView;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public UpdateItemView updateWeapons(WeaponForm form){
		UpdateItemView view = new UpdateItemView();
		
		int userId = form.getUserId();
		List<Param> params = form.getIds();
		
		weaponMapper.resetUserWeaponInUseStatus(DBConstants.InUseStatus.NotInUse, userId);
			
		if(params != null && params.size() > 0){
			List<Item> items = new ArrayList<>();
			
			Iterator<Param> iterator = params.iterator();
			while(iterator.hasNext()){
				int id = iterator.next().getId();
				
				UserWeapon userWeapon = weaponMapper.queryWeapon(id, userId, null).get(0);
				userWeapon.setInUse(DBConstants.InUseStatus.InUse);
				weaponMapper.updateUserWeapon(userWeapon);
				
				items.add(new Item(id, userWeapon.getWeaponRank()));
			}
			
			view.setItems(items);
		}
		
		return view;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public IntensifyUserWeaponView intensifyUserWeapon(IntensifyUserWeaponForm form){
		//是否付费,0-否，1-是
		String payStatus = form.getPayStatus();
		int userId = form.getUserId();
		if("1".equals(payStatus)){
			//付费类型,0-银币，1-付费币
			String payType = form.getPayType();
			int money = form.getMoney();
			User user = new User();
			user.setUserId(userId);
			if("0".equals(payType)){
				user.setMoney(money);
				//更新用户金额
				userMapper.updateUserMoney(user);
			}else{
				user.setSpecialMoney(money);
				//更新用户金额
				userMapper.updateUserSpecialMoney(user);
			}
		}
		
		//更新武器
		int id = form.getId();
		int weaponRank = form.getWeaponRank();
		UserWeapon userWeapon = new UserWeapon();
		userWeapon.setUserId(userId);
		userWeapon.setId(id);
		userWeapon.setWeaponRank(weaponRank);
		weaponMapper.updateUserWeapon(userWeapon);
		
		IntensifyUserWeaponView intensifyUserWeaponView = new IntensifyUserWeaponView();
		User resUser = userMapper.queryUserByUserId(userId);
		UserWeapon resUserWeapon = weaponMapper.queryWeapon(id, userId, null).get(0);
		intensifyUserWeaponView.setUser(resUser);
		intensifyUserWeaponView.setUserWeapon(resUserWeapon);
		return intensifyUserWeaponView;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public WeaponInfoView queryWeaponInfo(int userId) {
		int backpackCapacity = 0;
		int weaponStoreCapacity = 0;
		List<UserWeapon> userWeaponInfoList = userMapper.selectWeapons(userId, null);
		UserProp proinfo = null;
		WeaponInfoView weaponinfo = new WeaponInfoView();
		//retrieve capacity
	    UserProp prop= userMapper.queryUserPropByType(userId, DBConstants.UserProp.Bag);
	    UserProp prop2= userMapper.queryUserPropByType(userId, DBConstants.UserProp.WeaponRepository);
	    if(prop!=null){
	    	backpackCapacity =prop.getPropNum();
	    }
	    if(prop2!=null){
	    	 weaponStoreCapacity = prop2.getPropNum();
		}
		weaponinfo.setBackPackCapacity(backpackCapacity);;
		weaponinfo.setWeaponStoreCapacity(weaponStoreCapacity);;
		weaponinfo.setUserWeaponInfoList(userWeaponInfoList);
		return weaponinfo;
	}
	//获取用户的武器
	//List<UserWeapon> weaponList = userMapper.selectWeapons(userId, null);
}
