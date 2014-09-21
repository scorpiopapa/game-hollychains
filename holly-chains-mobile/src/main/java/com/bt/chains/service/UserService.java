package com.bt.chains.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bt.chains.bean.domain.ActiveCode;
import com.bt.chains.bean.domain.BaseData;
import com.bt.chains.bean.domain.CheckpointRole;
import com.bt.chains.bean.domain.Identity;
import com.bt.chains.bean.domain.ProductConfig;
import com.bt.chains.bean.domain.Prop;
import com.bt.chains.bean.domain.PropBuyHis;
import com.bt.chains.bean.domain.RewardConfig;
import com.bt.chains.bean.domain.RoleBaseData;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserAchievementHistory;
import com.bt.chains.bean.domain.UserAuth;
import com.bt.chains.bean.domain.UserMagic;
import com.bt.chains.bean.domain.UserProp;
import com.bt.chains.bean.domain.UserRewardStatus;
import com.bt.chains.bean.domain.UserRole;
import com.bt.chains.bean.domain.UserScore;
import com.bt.chains.bean.domain.UserWeapon;
import com.bt.chains.bean.domain.Weapon;
import com.bt.chains.bean.form.BindForm;
import com.bt.chains.bean.form.LoginForm;
import com.bt.chains.bean.form.PropBuyForm;
import com.bt.chains.bean.form.UpdateUserNameForm;
import com.bt.chains.bean.form.UserScoreForm;
import com.bt.chains.bean.view.BaseDataView;
import com.bt.chains.bean.view.BindResult;
import com.bt.chains.bean.view.BuyGemView;
import com.bt.chains.bean.view.MainView;
import com.bt.chains.bean.view.PropBuyView;
import com.bt.chains.bean.view.PropListView;
import com.bt.chains.bean.view.ShopWeaponMenu;
import com.bt.chains.bean.view.UserScoreView;
import com.bt.chains.bean.view.UserView;
import com.bt.chains.constant.DBConstants;
import com.bt.chains.constant.DBConstants.RewardType;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.mapper.CheckpointsMapper;
import com.bt.chains.mapper.GashaMapper;
import com.bt.chains.mapper.MagicMapper;
import com.bt.chains.mapper.RewardMapper;
import com.bt.chains.mapper.RoleMapper;
import com.bt.chains.mapper.UserMapper;
import com.bt.chains.mapper.WeaponMapper;
import com.bt.chains.util.DBUtils;
import com.bt.chains.util.ObjectUtils;

@Service
public class UserService {
	private final static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private GameSettingRepository repository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RewardMapper rewardMapper;
	
	@Autowired
	private WeaponMapper weaponMapper;
	
	@Autowired
	private GashaMapper gashaMapper;
	
	@Autowired RoleMapper roleMapper;
	
	@Autowired MagicMapper magicMapper;
	
	@Autowired 
	CheckpointsMapper checkpointsMapper;
	
	@Autowired
	private ValidationService validationService;
	@Autowired
	private RewardService rewardService;
	@Autowired
	private GameSettingRepository gameSettingRepository;
	
	@Transactional(rollbackFor=Exception.class)
	public MainView login(LoginForm form){
		User user = userMapper.selectUserByMarket(form.getId());
		int userId;
		String status = DBConstants.YES;
		Date today = DBUtils.getCurrentTimestamp();
		
		log.debug("login user is {}", user);
		
		String marketId = StringUtils.trimToEmpty(form.getId());
		
		if(user != null){
			marketId = user.getMarketId();
			
			userId = user.getUserId();
			
			// update login time
			user.setLastConnectedTime(today);
			user.setLoginTime(today);
			userMapper.updateUser(user);
			
			if(user.getBindUserId() != 0){
				// 用户已绑定设备，使用绑定的用户id
				userId = user.getBindUserId();
				status = DBConstants.NO;
			}
		}else{
			// newly registered user
			user = new User();
			// if passed empty market id, generate a market id automatically
			marketId = StringUtils.isBlank(form.getId()) ? 
								StringUtils.replace(UUID.randomUUID().toString(), "-", "") : 
								marketId;
			user.setName("player");
			user.setStatus(DBConstants.YES);
			user.setRegisterTime(today);
			user.setLastConnectedTime(today);
			user.setLoginTime(today);
			user.setMoney(repository.getInt(GameSettingRepository.USER_INIT_MONEY));
			user.setSpecialMoney(repository.getInt(GameSettingRepository.USER_INIT_SPECIAL_MONEY));
			user.setPower(DBConstants.POWER);
			user.setMarketId(marketId);
			user.setMarket(form.getMarket());
			log.info("insert user to db");
			userMapper.insertUser(user);
			
			userId = user.getUserId();
	
//			UserMarket userMarket = new UserMarket();
//			userMarket.setUserId(userId);
//			userMarket.setMarketId(form.getId());
//			userMarket.setMarket(form.getMarket());
//			userMarket.setCreateDate(DBUtils.getCurrentTimestamp());
//			log.info("insert usermarket to db");
//			userMapper.insertUserMarket(userMarket);
			
			//创建默认用户职业
			UserRole userRole = new UserRole();
			userRole.setUserId(userId);
			userRole.setRoleId(DBConstants.DefUserRole.roleId);   //默认是人类
			userRole.setRoleRank(DBConstants.DefUserRole.roleRank);  //默认是1级
			userRole.setInUse(DBConstants.InUseStatus.InUse);    //默认选中
			userMapper.insertUserRole(userRole);
			
			//初始化用户背包数量
			UserProp up1 = new UserProp();
			up1.setUserId(userId);
			up1.setPropType(DBConstants.UserProp.Bag+"");
			up1.setPropId(3);
			up1.setPropNum(gameSettingRepository.getInt(GameSettingRepository.USER_BAG));
			userMapper.insertUserProp(up1);
			
			//初始化用户武器仓库数量
			UserProp up2 = new UserProp();
			up2.setUserId(userId);
			up2.setPropType(DBConstants.UserProp.WeaponRepository+"");
			up2.setPropId(9);
			up2.setPropNum(gameSettingRepository.getInt(GameSettingRepository.USER_STORE));
			userMapper.insertUserProp(up2);
			
			//新增一条武器制造券
			UserProp up3 = new UserProp();
			up3.setUserId(userId);
			up3.setPropType(DBConstants.UserProp.GashaTicket+"");
			up3.setPropId(1);
			up3.setPropNum(1);
			userMapper.insertUserProp(up3);
		}
		
		//奖励基本信息
		List<RewardConfig> rewardConfig = rewardMapper.getRewardConfig();
		Map<Integer, Map<Integer, RewardConfig>> rewardConfigMap = new HashMap<Integer, Map<Integer, RewardConfig>>();
		for(RewardConfig rc : rewardConfig){
			if(rc.getRewardType() > 0){
				if(rewardConfigMap.get(rc.getRewardType()) == null){
					Map<Integer, RewardConfig> rcMap = new HashMap<Integer, RewardConfig>();
					rewardConfigMap.put(rc.getRewardType(), rcMap);
					rcMap.put(rc.getId(), rc);
				}else{
					rewardConfigMap.get(rc.getRewardType()).put(rc.getId(), rc);
				}
			}
		}
		//用户奖励信息
		List<UserAchievementHistory> ahvList = userMapper.selectUserAchievementHistory(userId, null, null, null, null);
		
		if(ahvList.size() == 0){
			// TODO 初始化成就信息。 “Y”：完成， “N”：未完成
			insertUserAchievementHistory(userId, 1001, "Y", "N", 1);
			insertUserAchievementHistory(userId, 2001, "Y", "N", 2);
			insertUserAchievementHistory(userId, 3001, "N", "N", 3);
			insertUserAchievementHistory(userId, 4001, "N", "N", 4);
			insertUserAchievementHistory(userId, 5001, "N", "N", 5);
			insertUserAchievementHistory(userId, 6001, "N", "N", 6);
			insertUserAchievementHistory(userId, 7001, "N", "N", 7);
			insertUserAchievementHistory(userId, 8001, "N", "N", 8);
			
			//for testing
			rewardService.processRewardStatus(userId, RewardType.MoneySum, 0);
			rewardService.processRewardStatus(userId, RewardType.SpecialMoneySum, 0);
		}else{
			//<type, <id, urc>>
			Map<Integer, Map<Integer, UserAchievementHistory>> ahvMap = new HashMap<Integer, Map<Integer,UserAchievementHistory>>();
			for(UserAchievementHistory uv : ahvList){
				if(uv.getType() > 0){
					if(ahvMap.get(uv.getType()) == null){
						Map<Integer, UserAchievementHistory> uahMap = new HashMap<Integer, UserAchievementHistory>();
						ahvMap.put(uv.getType(), uahMap);
						uahMap.put(uv.getRewardId(), uv);
					}else{
						ahvMap.get(uv.getType()).put(uv.getRewardId(), uv);
					}
				}
			}
			//用户奖励信息处理
			operateAchivement(userId, rewardConfigMap, ahvMap);
			//for testing
			rewardService.processRewardStatus(userId, RewardType.MoneySum, 0);
			rewardService.processRewardStatus(userId, RewardType.SpecialMoneySum, 0);
		}
		
		MainView view = getLoginUser(userId, status);
		view.setMarketId(marketId);
		
		return view;
	}
	private void operateAchivement(int userId, Map<Integer, Map<Integer, RewardConfig>> rewardConfigMap, 
			Map<Integer, Map<Integer, UserAchievementHistory>>  ahvMap) {
		//循环用户archivement数据
		for(int type : ahvMap.keySet()){
			if(type ==1 || type==2){
				//key： USER_ACHIEVEMENT_HIS.id
				Map<Integer, UserAchievementHistory> uahMap = ahvMap.get(type);
				//key: REWARD_CONFIG.id
				Map<Integer, RewardConfig> rcMap = rewardConfigMap.get(type);
				SimpleDateFormat timeFormater = new SimpleDateFormat("yyyyMMdd");        
				int today = Integer.parseInt(timeFormater.format(new Date()));
				
				//测试用 start
			    Calendar calendarTest = Calendar.getInstance();
			    calendarTest.setTime(new Date());
			    calendarTest.add(Calendar.DAY_OF_MONTH, repository.getInt(GameSettingRepository.MONTH_SHIFT));
			    Date date1= calendarTest.getTime();
			    today = Integer.parseInt(timeFormater.format(date1));
			    //end
			    
				//获得最新achive数据。 
				int maxRewardId = getMaxKey(uahMap); 
				switch(type){
				//每日登陆奖励
				case RewardType.DailyLogin:
					
					int day = Integer.parseInt(timeFormater.format(uahMap.get(maxRewardId).getCreateDate()));
					if(day < today){
						int rewardId = maxRewardId;
						//之前每日登陆奖励不可领取
						for(int key : uahMap.keySet()){
							UserAchievementHistory uah = uahMap.get(key);
							String status = uah.getStatus();
							if(!status.equals("Y")){
								updateUserAchievementHistory(uah.getId(), "Y", "Y");
							}
						}
						//如果当日第一次登陆，插入奖励信息
						insertUserAchievementHistory(userId, rewardId, "Y", "N", type);
					}
					break;
				//累计登陆奖励
				case RewardType.LoginSum:
					//查询当月登陆天数
//					Date date = new Date();//当前日期
//					String minMonthDate = getMinMonthDate(date, "yyyyMMdd");
					String minMonthDate = getMinMonthDate(date1, "yyyyMMdd");
					
				    Calendar calendar = Calendar.getInstance();
//				    calendar.setTime(date);
				    calendar.setTime(date1);
				    
				    calendar.add(calendar.MONTH, 1);
					String nextMinMonthDate = getMinMonthDate(calendar.getTime(), "yyyyMMdd");
					//查询本月登陆天数，如果达到下一标准，插入his表中
					int days = rewardMapper.queryCurrMonthLoginSum(userId, RewardType.DailyLogin, minMonthDate, nextMinMonthDate);
					
					//如果该achievement信息已有并且未完成，则update，否则插入一条
					if(uahMap.get(maxRewardId).getCompStatus().equals("N") && days>=Integer.parseInt(rcMap.get(maxRewardId).getCategory())){
						updateUserAchievementHistory(uahMap.get(maxRewardId).getId(), "Y", "N");
					}else{
						int category = Integer.parseInt(rcMap.get(maxRewardId+1).getCategory());
						if(days >= category){
							insertUserAchievementHistory(userId, maxRewardId+1, "Y", "N", type);
						}
					}
					break;
				}
			}
		}
		
	}
    
	public int queryCurrMonthLoginSum(int userId){
		//查询当月登陆天数
		
		//测试用 start
	    Calendar calendarTest = Calendar.getInstance();
	    calendarTest.setTime(new Date());
	    calendarTest.add(Calendar.DAY_OF_MONTH, repository.getInt(GameSettingRepository.MONTH_SHIFT));
	    Date date= calendarTest.getTime();
	    //end
	    
//		Date date = new Date();//当前日期
		String minMonthDate = getMinMonthDate(date, "yyyyMMdd");
		
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(calendar.MONTH, 1);
		String nextMinMonthDate = getMinMonthDate(calendar.getTime(), "yyyyMMdd");
		//查询本月登陆天数，如果达到下一标准，插入his表中
		int days = rewardMapper.queryCurrMonthLoginSum(userId, RewardType.DailyLogin, minMonthDate, nextMinMonthDate);
		return days;
	}
	public String getMinMonthDate(Date date, String format){  
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));  
        return dateFormat.format(calendar.getTime());  
    } 
    
	public void insertUserAchievementHistory(int userId, int rewardId, String compStatus, String status, int type){
		UserAchievementHistory userAchievementHistory = new UserAchievementHistory();
		userAchievementHistory.setUserId(userId);
		userAchievementHistory.setRewardId(rewardId);
		userAchievementHistory.setCompStatus(compStatus);
		userAchievementHistory.setStatus(status);
		userAchievementHistory.setType(type);
		
		//测试用 start
	    Calendar calendarTest = Calendar.getInstance();
	    calendarTest.setTime(new Date());
	    calendarTest.add(Calendar.DAY_OF_MONTH, repository.getInt(GameSettingRepository.MONTH_SHIFT));
	    Date date1= calendarTest.getTime();
	    //end
	    userAchievementHistory.setCreateDate(date1);
//		userAchievementHistory.setCreateDate(new Date());
		userMapper.insertUserAchievementHistory(userAchievementHistory);
	}
	
	public void updateUserAchievementHistory(int id, String compStatus, String pickStatus){
		UserAchievementHistory userAchievementHistory = new UserAchievementHistory();
		userAchievementHistory.setId(id);
		userAchievementHistory.setCompStatus(compStatus);
		userAchievementHistory.setStatus(pickStatus);
		//测试用 start
	    Calendar calendarTest = Calendar.getInstance();
	    calendarTest.setTime(new Date());
	    calendarTest.add(Calendar.DAY_OF_MONTH, repository.getInt(GameSettingRepository.MONTH_SHIFT));
	    Date date1= calendarTest.getTime();
	    //end
	    userAchievementHistory.setUpdateDate(date1);
	    
//		userAchievementHistory.setUpdateDate(new Date());
		userMapper.updateUserAchievementHistory(userAchievementHistory);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED) 
	public MainView getLoginUser(int userId, String status){
		MainView view = new MainView();
		
		view.setUserId(userId);
		
		User user = userMapper.selectLoginUser(userId, status);
		if(user != null){
			view.setName(user.getName());
//		MainView user = new MainView();
			//武器、魔法、职业存放在客户端，不用从后台查询
			
			//获取用户职业
			//获取用户职业信息
			List<UserRole> jobList = userMapper.selectJobs(userId);
			//获取用户的武器
			//List<UserWeapon> weaponList = userMapper.selectWeapons(userId, null);
//			//获取用户的魔法
//			List<UserMagic> magicList = userMapper.selectMagics(userId);
			
			//获取用户最后一次使用的职业
//			UserRole userRole = userMapper.selectLastUseRole(userId);
			UserRole userRole = roleMapper.queryRole(userId, null, DBConstants.InUseStatus.InUse);
			//获取用户最后一次使用的武器
//			List<UserWeapon> lastUseWeapons = userMapper.selectLastUseWeapons(userId);
			List<UserWeapon> lastUseWeapons = weaponMapper.queryWeapon(null, userId, DBConstants.InUseStatus.InUse);
			//获取用户最后一次使用的魔法
//			List<UserMagic> lastUseMagics = userMapper.selectLastUseMagics(userId);
			List<UserMagic> lastUseMagics = magicMapper.queryeMagic(userId, null, DBConstants.InUseStatus.InUse);
			
			view.setJobList(jobList);
			//user.setWeaponList(weaponList);
//			view.setMagicList(magicList);
			
			// 默认职业为人类
			int roleId = 1;
			if(userRole != null){
				roleId = userRole.getRoleId();
			}
			view.setLastRoleId(roleId);
			
			view.setMoney(user.getMoney());
			view.setSpecialMoney(user.getSpecialMoney());
			
			view.setLastUserWeaponList(ObjectUtils.convertUserWeaponNew(lastUseWeapons));
			view.setLastUserMagicList(ObjectUtils.convertUserMagicNew(lastUseMagics));
			
			List<ProductConfig> configs = gashaMapper.selectProductConfig();
			List<Identity> ids = new ArrayList<>();
			for(ProductConfig c : configs){
				Identity id = new Identity();
				id.setId(c.getProductId());
				ids.add(id);
			}
			
			view.setProductIds(ids);
			
			//查询用户持有武器制造券个数
			UserProp up = new UserProp();
			up.setUserId(userId);
			up.setPropType("3");
			int count = userMapper.queryUserPropCount(up);
			int weaponTicketCount = 0;
			if(count > 0){
				weaponTicketCount = userMapper.queryUserPropNum(userId, "3");
			}
			view.setWeaponTicketCount(weaponTicketCount);
			//查询用户持有炼狱模式参加券个数
			up.setPropType("4");
			count = userMapper.queryUserPropCount(up);
			int unlimitedTicketCount = 0;
			if(count > 0){
				unlimitedTicketCount = userMapper.queryUserPropNum(userId, "4");
			}
			view.setUnlimitedTicketCount(unlimitedTicketCount);
			
			//获取购买武器菜单
			List<ShopWeaponMenu> shopWeaponMenu = gashaMapper.getWeaponPurchase(null);
			
			//获取购买道具的菜单
			PropListView propListView = this.queryPropList(userId);
			List<Prop> prop = propListView.getPropList();
			
			view.setProp(prop);
			view.setShopWeaponMenu(shopWeaponMenu);
			
			//计算基础数据值
			List<BaseData> baseDatas = null;
			int blood = 0, bloodReply = 0, baseAttack = 0, attack = 0, shield = 0, defenseShield = 0, vampire = 0, 
					critRate = 0, penetrationRate = 0;
			//计算职业各个基础数据的数值
			UserRole ur = roleMapper.queryRole(userId, roleId, DBConstants.InUseStatus.InUse);
			if(ur != null){
				RoleBaseData roleBaseData = roleMapper.selectRoleBaseData(roleId, ur.getRoleRank());
				if(roleBaseData != null){
					blood += roleBaseData.getHealth();
					bloodReply += roleBaseData.getHealthPortion();
					baseAttack += roleBaseData.getBasicDamage();
					attack += roleBaseData.getWeaponDamage();
					shield += roleBaseData.getShield();
					defenseShield += roleBaseData.getShieldDefence();
					vampire += (roleBaseData.getLeech() * 10);
					critRate += (roleBaseData.getCriticalDamage() * 10);
					penetrationRate += (roleBaseData.getPierce() * 10);
				}
			}
			
			List<UserWeapon> userWeapons = userMapper.selectInUseWeapon(userId, DBConstants.InUseStatus.InUse);
			if(userWeapons != null && userWeapons.size() > 0){
				Iterator<UserWeapon> iterator = userWeapons.iterator();
				while(iterator.hasNext()){
					//计算武器各个基础数据的数值
					UserWeapon userWeapon = iterator.next();
					int weaponId = userWeapon.getWeaponId();
					int weaponRank = userWeapon.getWeaponRank();
					List<Weapon> ls = weaponMapper.queryWeaponBaseData(null, weaponId, null);
					if(ls != null && ls.size() > 0){
						Weapon w = ls.get(0);
						blood += w.getMaxBlood() + (weaponRank - 1) * w.getMinBlood();
						bloodReply += w.getMaxBloodReply() + (weaponRank - 1) * w.getMinBloodReply();
						baseAttack += w.getMaxBaseAttack() + (weaponRank - 1) * w.getMinBaseAttack();
						attack += w.getMaxAttack() + (weaponRank - 1) * w.getMinAttack();
						shield += w.getMaxShield() + (weaponRank - 1) * w.getMinShield();
						defenseShield += w.getMaxDefenseShield() + (weaponRank - 1) * w.getMinDefenseShield();
						vampire += ((w.getMaxVampire() + (weaponRank - 1) * w.getMinVampire()) * 10);
						critRate += ((w.getMaxCritRate() + (weaponRank - 1) * w.getMinCritRate()) * 10);
						penetrationRate += ((w.getMaxPenetrationRate() + (weaponRank - 1) * w.getMinPenetrationRate()) * 10);
					}
				}
			}
			baseDatas = new ArrayList<BaseData>();
			BaseData baseData1 = new BaseData();
			baseData1.setId(0);
			baseData1.setData(blood);
			BaseData baseData2 = new BaseData();
			baseData2.setId(1);
			baseData2.setData(bloodReply);
			BaseData baseData3 = new BaseData();
			baseData3.setId(2);
			baseData3.setData(baseAttack);
			BaseData baseData4 = new BaseData();
			baseData4.setId(3);
			baseData4.setData(attack);
			BaseData baseData5 = new BaseData();
			baseData5.setId(4);
			baseData5.setData(shield);
			BaseData baseData6 = new BaseData();
			baseData6.setId(5);
			baseData6.setData(defenseShield);
			BaseData baseData7 = new BaseData();
			baseData7.setId(6);
			baseData7.setData(vampire);
			BaseData baseData8 = new BaseData();
			baseData8.setId(7);
			baseData8.setData(critRate);
			BaseData baseData9 = new BaseData();
			baseData9.setId(8);
			baseData9.setData(penetrationRate);
			baseDatas.add(baseData1);
			baseDatas.add(baseData2);
			baseDatas.add(baseData3);
			baseDatas.add(baseData4);
			baseDatas.add(baseData5);
			baseDatas.add(baseData6);
			baseDatas.add(baseData7);
			baseDatas.add(baseData8);
			baseDatas.add(baseData9);
			
			view.setBaseDatas(baseDatas);
		}
		
		return view;
	}
	
	
//	@Transactional(rollbackFor=Exception.class)
//	public int insertUserLastRecords(UserLastRecordsForm form) {
//		int userId = form.getUserId();
//		
//		List<UserLastRecords> roles = form.getRoles();
//		List<UserLastRecords> weapons = form.getWeapons();
//		List<UserLastRecords> magics = form.getMagics();
//		
//		if((roles != null && roles.size() > 0)
//				|| (weapons != null && weapons.size() > 0)
//				|| (magics != null && magics.size() > 0)){
//			//删除用户最后一次记录
//			userMapper.deteleUserRecord(userId);
//			//插入最后一次职业
//			if(roles != null && roles.size() > 0){
//				Iterator<UserLastRecords> roleIterator = roles.iterator();
//				while(roleIterator.hasNext()){
//					UserLastRecords userLastRecords = roleIterator.next();
//					userLastRecords.setUserId(userId);
//					userMapper.insertUserLastRecords(userLastRecords);
//				}
//			}
//			//插入最后一次武器
//			if(weapons != null && weapons.size() > 0){
//				Iterator<UserLastRecords> weaponIterator = weapons.iterator();
//				while(weaponIterator.hasNext()){
//					UserLastRecords userLastRecords = weaponIterator.next();
//					userLastRecords.setUserId(userId);
//					userMapper.insertUserLastRecords(userLastRecords);
//				}
//			}
//			//插入最后一次魔法
//			if(magics != null && magics.size() > 0){
//				Iterator<UserLastRecords> magicIterator = magics.iterator();
//				while(magicIterator.hasNext()){
//					UserLastRecords userLastRecords = magicIterator.next();
//					userLastRecords.setUserId(userId);
//					userMapper.insertUserLastRecords(userLastRecords);
//				}
//			}
//		}else{
//			return 0;
//		}
//		return 1;
//	}
	
	@Transactional(rollbackFor=Exception.class)
	public PropBuyView propBuy(PropBuyForm propBuyForm) throws RequestException{
		int userId = propBuyForm.getUserId();
		int propId = propBuyForm.getPropId();
		
		//根据propId查询道具信息
		Prop prop = userMapper.selectPropById(propId);
		int specialMoney = prop.getPropPrice();
		String propType = prop.getPropType();
		int propNum = prop.getPropNum();
		
		validationService.validateGem(userId, specialMoney);
		
		PropBuyHis propBuyHis = new PropBuyHis();
		propBuyHis.setUserId(userId);
		propBuyHis.setPropId(propId);
		propBuyHis.setSpecialMoney(specialMoney);
		//插入用户购买道具历史表
		userMapper.insertPropBuyHis(propBuyHis);
		
		UserProp userProp = new UserProp();
		//如果购买体力恢复剂，只更新历史记录表，不存入到用户道具表中
		if(!"0".equals(propType)){
			userProp.setUserId(userId);
			userProp.setPropId(propId);
			userProp.setPropType(propType);
			userProp.setPropNum(propNum);
			//判断该用户是否已经有该道具
			int count = userMapper.queryUserPropCount(userProp);
			if(count > 0){
				//修改用户道具信息
				userMapper.updateUProp(userProp);
			}else{
				//插入用户道具信息
				userMapper.insertUserProp(userProp);
			}
		}
		//购买体力恢复剂，需要更新用户体力
		else{
//			User pUser = new User();
//			pUser.setUserId(userId);
//			//体力数增加50
//			pUser.setPower(50);
//			userMapper.addPower(pUser);
		}
		
		//扣除用户付费币数量
		User user = new User();
		user.setUserId(userId);
		user.setSpecialMoney(specialMoney);
		userMapper.updateUserSpecialMoney(user);
		
		//返回数据
		PropBuyView propBuyView = new PropBuyView();
		
		//查询购买道具列表，客户端可以根据数据重新渲染
		PropListView view = this.queryPropList(userId);
		propBuyView.setPropList(view.getPropList());
		
		User u = userMapper.selectUser(userId);
		BuyGemView buyGemView = new BuyGemView();
		buyGemView.setMoney(u.getMoney());
		buyGemView.setSpecialMoney(u.getSpecialMoney());
		propBuyView.setBalance(buyGemView);
		return propBuyView;
	}
	
	public PropListView queryPropList(int userId){
		PropListView propListView = new PropListView();
		
		List<Prop> propList = new ArrayList<Prop>();
		
		//背包道具
		UserProp prop1 = userMapper.queryUserPropByType(userId, DBConstants.UserProp.Bag);
		//已经含有背包道具
		if(prop1 != null){
			//查询下一级别道具信息
			Prop prop = userMapper.selectNextProp(prop1.getPropId(), DBConstants.UserProp.Bag + "");
			//如果没有下一级别的道具
			if(prop == null){
				//获取当前级别道具，并且设置status字段为Y，前台根据这个字段可以把当前列表项设置成灰色
				prop = userMapper.selectPropById(prop1.getPropId());
				prop.setStatus("N");
			}else{
				prop.setStatus("Y");
			}
			propList.add(prop);
		}else{
			Prop prop = userMapper.selectProp(DBConstants.UserProp.Bag + "");
			propList.add(prop);
		}
		
		//仓库道具
		UserProp prop2 = userMapper.queryUserPropByType(userId, DBConstants.UserProp.WeaponRepository);
		if(prop2 != null){
			//查询下一级别道具信息
			Prop prop = userMapper.selectNextProp(prop2.getPropId(), DBConstants.UserProp.WeaponRepository + "");
			//如果没有下一级别的道具
			if(prop == null){
				//获取当前级别道具，并且设置status字段为Y，前台根据这个字段可以把当前列表项设置成灰色
				prop = userMapper.selectPropById(prop2.getPropId());
				prop.setStatus("N");
			}else{
				prop.setStatus("Y");
			}
			propList.add(prop);
		}else{
			Prop prop = userMapper.selectProp(DBConstants.UserProp.WeaponRepository + "");
			propList.add(prop);
		}
		
		//体力恢复剂
		Prop powerProp = userMapper.selectProp(DBConstants.UserProp.Power + "");
		propList.add(powerProp);
		propListView.setPropList(propList);
		
		return propListView;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public BuyGemView buyGem(String productId, int userId) throws RequestException{
		//根据productId查询购买宝石的数量
		ProductConfig pConfig = userMapper.selectGem(productId);
		int gemNumber = pConfig.getGemNumber();
		
		//判断用户购买宝石数据是否超出 允许的最大值
		User user = userMapper.selectUser(userId);
		int specialMoney = user.getSpecialMoney();
		if((gemNumber + specialMoney) > DBConstants.User.maxGem){
			throw new RequestException(ErrorCodeConstants.GEM_MAX_ERROR, ErrorCodeConstants.GEM_MAX_MSG);
		}
		
		//更新用户宝石数量
		userMapper.updateAddGem(userId, gemNumber);
		
		//更新宝石累计量并判断是否需要插入成就
		rewardService.processRewardStatus(userId, RewardType.SpecialMoneySum, gemNumber);
		
		user = userMapper.selectUser(userId);
		
		BuyGemView buyGemView = new BuyGemView();
		buyGemView.setMoney(user.getMoney());
		buyGemView.setSpecialMoney(user.getSpecialMoney());
		return buyGemView;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public UserScoreView saveUserScore(UserScoreForm userScoreForm) throws RequestException{
		UserScoreView userScoreView = new UserScoreView();
		
		int userId = userScoreForm.getUserId();
		int score = userScoreForm.getScore();
		int roleId = 1;
		String type = userScoreForm.getType();
		
		//查询用户关卡模式选择的用户职业
		List<CheckpointRole> checkpointRoles = checkpointsMapper.queryCheckpointRole(userId, type);
		if(checkpointRoles != null && checkpointRoles.size() > 0){
			CheckpointRole checkpointRole = checkpointRoles.get(0);
			roleId = checkpointRole.getRoleId();
		}else{
			throw new RequestException(ErrorCodeConstants.NO_DATA_ERROR, ErrorCodeConstants.NO_DATA_MSG);
		}
		
		User user = userMapper.queryUserByUserId(userScoreForm.getUserId());
		String userName = user.getName();
		
		UserScore userScore = new UserScore();
		userScore.setUserId(userId);
		userScore.setScore(score);
		userScore.setType(type);
		userScore.setRoleId(roleId);
		userScore.setUserName(userName);
		//查询用户积分
		int count = userMapper.queryUserScoreCount(userId, type);
		if(count == 10){
			UserScore userMinScore = userMapper.queryUserMinScore(userId, type);
			if(userMinScore != null){
				int soreMin = userMinScore.getScore();
				if(score > soreMin){
					//将最小的积分替换成当前的积分
					UserScore us = new UserScore();
					us.setId(userMinScore.getId());
					us.setType(userMinScore.getType());
					us.setScore(score);
					us.setUserId(userId);
					us.setRoleId(roleId);
					userMapper.updateUserScore(us);
				}
			}
		}else{
			//保存用户积分信息
			userMapper.saveUserScore(userScore);
		}
		
		
		//获取所有用户
		int allUserCount = userMapper.queryAllUserCount(type);
		//当前用户排名
		int userRankings = userMapper.queryUserRankings(score, type);
		
		//计算用户当前成绩占所有玩家的前百分之几
		int category = (int)((float)(userRankings / allUserCount) * 100);
		
		RewardConfig rewardConfig = null;
		//随即无限模式
		if("R".equals(type)){
			//判断应该获取的奖励信息
			rewardConfig = rewardMapper.queryUserReward(category, 9);
		}
		//自定义无限模式
		else if("C".equals(type)){
			//判断应该获取的奖励信息
			rewardConfig = rewardMapper.queryUserReward(category, 10);
		}
		
		if(rewardConfig != null){
			//将奖励更新到用户信息中
			//奖励金币数量
			int money = rewardConfig.getMoney();
			if(money > 0){
				User pUser = new User();
				pUser.setMoney(money);
				pUser.setUserId(userId);
				//增加用户银币数量
				userMapper.addUserMoney(pUser);
				userScoreView.setRewardMoney(money);
				
				rewardService.processRewardStatus(userId, RewardType.MoneySum, money);
			}
			
			//增加用户武器
//			int weaponId = rewardConfig.getWeapon();
//			int weaponCount = rewardConfig.getWeaponCount();
//			for(int i = 0; i < weaponCount; i++){
//				UserWeapon userWeapon = new UserWeapon();
//				userWeapon.setUserId(userId);
//				userWeapon.setWeaponId(weaponId);
//				//设置默认一级
//				userWeapon.setWeaponRank(1);
//				weaponMapper.insertUserWeapon(userWeapon);
//			}
			
			//更新用户道具
			int propId = rewardConfig.getProp();
			int propCount = rewardConfig.getPropCount();
			
			//更具道具ID查询道具名称
			Prop prop = userMapper.selectPropById(propId);
			if(prop != null){
				userScoreView.setPropName(prop.getPropName());
			}
			
			userScoreView.setPropCount(propCount);
			
			UserProp pUserProp = new UserProp();
			pUserProp.setUserId(userId);
			pUserProp.setPropId(propId);
			
			UserProp userProp = userMapper.queryUserProp(userId, propId);
			pUserProp.setPropNum(propCount);
			if(userProp != null){
				//更新用户道具数量
				userMapper.updateUserPropNum(userProp);
			}else{
				//插入用户道具信息
				pUserProp.setPropType(DBConstants.UserProp.GashaTicket+"");
				userMapper.insertUserProp(pUserProp);
			}
		}
		//获取用户信息
		User u = userMapper.queryUserByUserId(userId);
		if(u != null){
			userScoreView.setMoneyBalance(u.getMoney());
			userScoreView.setGemBalance(u.getSpecialMoney());
		}
		//获取用户的武器
//		List<UserWeapon> weapons = userMapper.selectWeapons(userId, null);
//		//获取用户道具信息
//		List<UserProp> props = userMapper.queryUserProps(userId);
		
		
//		userScoreView.setUser(user);
//		userScoreView.setWeapons(weapons);
//		userScoreView.setProps(props);
//		userScoreView.setRewardConfig(rewardConfig);
//		userScoreView.setUserScore(userScore);
		
		userScoreView.setMoneyBalance(user.getMoney());
		// TODO 添加用户获得的金币数，道具id和道具数量
		
		return userScoreView;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public ActiveCode getCode(int userId) throws RequestException{
		validationService.validateBindStatus(userId);
		String code = StringUtils.replace(UUID.randomUUID().toString(), "-", "").substring(0, 5);
		
		UserAuth userAuth = userMapper.selectUserAuth(userId);
		Date today = DBUtils.getCurrentTimestamp();
		
		if(userAuth == null){
			//创建切换码
			UserAuth ua = new UserAuth();
			ua.setCode(code);
			ua.setCreateDate(today);
			ua.setExpired(DBConstants.NO);
			ua.setUserId(userId);
			userMapper.insertUserAuth(ua);
		}else{
			Date createDate = userAuth.getCreateDate();
			Date expireDate = DateUtils.addDays(createDate, DBConstants.codeExpired.expiredDate);
			if(today.compareTo(expireDate) < 0){
				// 没有过期，获取切换码
				code = userAuth.getCode();
			}else{
				//过期
				userAuth.setExpired(DBConstants.YES);
				userAuth.setUpdateDate(today);
				userMapper.updateUserAuth(userAuth);
				
				//创建切换码
				UserAuth ua = new UserAuth();
				ua.setCode(code);
				ua.setCreateDate(today);
				ua.setExpired(DBConstants.NO);
				ua.setUserId(userId);
				userMapper.insertUserAuth(ua);
			}
		}
		
		ActiveCode ac = new ActiveCode();
		ac.setActiveCode(code);
		
		return ac;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public BindResult bindDevice(BindForm form) throws RequestException{
		UserAuth userAuth = validationService.validateBindDevice(form.getId(), String.valueOf(form.getCode()));
		userAuth.setExpired(DBConstants.YES);
		userAuth.setUpdateDate(DBUtils.getCurrentTimestamp());
		userAuth.setBindUserId(form.getUserId());
		userMapper.updateUserAuth(userAuth);
		
//		UserAuthMarket userAuthMarket = new UserAuthMarket();
//		userAuthMarket.setsId(userAuth.getsId());
//		userAuthMarket.setUserId(form.getUserId());
//		userAuthMarket.setMarketId(form.getMarketId());
//		userAuthMarket.setMarket(form.getMarket());
//		userMapper.insertUserAuthMarket(userAuthMarket);
		
		// 将目标用户marketid置为不可用
		User user = userMapper.selectUser(form.getId());
		user.setStatus(DBConstants.NO);
		userMapper.updateUserStatus(user);
		
		// 将已经绑定到目标账号的所有账号置为不可用
		userMapper.updateBindUserStatus(form.getId());
		
		// 关联新用户id和目标用户id
		user = userMapper.selectUser(form.getUserId());
		
		// 找到最初始的用户id
//		User sourceUser = userMapper.selectUser(form.getId());
//		while(sourceUser.getBindUserId() > 0){
//			sourceUser = userMapper.selectUser(sourceUser.getBindUserId());
//		}
//		user.setBindUserId(sourceUser.getUserId());
		
		user.setBindUserId(form.getId());
		userMapper.updateUserStatus(user);
		
//		//插入新的市场ID
//		UserMarket userMarket = new UserMarket();
//		userMarket.setUserId(form.getUserId());
//		userMarket.setMarketId(form.getMarketId());
//		userMarket.setMarket(form.getMarket());
//		userMarket.setCreateDate(DBUtils.getCurrentTimestamp());
//		log.info("insert usermarket to db");
//		userMapper.insertUserMarket(userMarket);
		
		BindResult result = new BindResult();
		result.setUserId(user.getUserId());
		return result;
		
	}
	
	@Transactional(rollbackFor=Exception.class)
	public UserView updateUserName(UpdateUserNameForm form){
		int userId = form.getUserId();
		String userName = form.getUserName();
		//修改用户名称
		userMapper.updateUserName(userId, userName);
		//查询用户信息
		User user = userMapper.queryUserByUserId(userId);
		
		UserView userView = new UserView();
		userView.setUser(user);
		return userView;
	}
	
	public int getMaxKey(Map moneyAcvMap){
		int maxValue = Integer.MIN_VALUE; 
		Set<Integer> keys = moneyAcvMap.keySet();         
		for(Integer key : keys){
			if(maxValue < key){                 
				maxValue = key;             
			}         
		}
		return maxValue;
	}
	
	public BaseDataView queryBaseData(int userId){
		List<BaseData> baseDatas = null;
		int blood = 0, bloodReply = 0, baseAttack = 0, attack = 0, shield = 0, defenseShield = 0, vampire = 0, 
				critRate = 0, penetrationRate = 0;
		
		//计算职业各个基础数据的数值
		UserRole ur = roleMapper.queryRole(userId, null, DBConstants.InUseStatus.InUse);
		if(ur != null){
			RoleBaseData roleBaseData = roleMapper.selectRoleBaseData(ur.getRoleId(), ur.getRoleRank());
			if(roleBaseData != null){
				blood += roleBaseData.getHealth();
				bloodReply += roleBaseData.getHealthPortion();
				baseAttack += roleBaseData.getBasicDamage();
				attack += roleBaseData.getWeaponDamage();
				shield += roleBaseData.getShield();
				defenseShield += roleBaseData.getShieldDefence();
				vampire += (roleBaseData.getLeech() * 10);
				critRate += (roleBaseData.getCriticalDamage() * 10);
				penetrationRate += (roleBaseData.getPierce() * 10);
			}
		}
		
		List<UserWeapon> userWeapons = userMapper.selectInUseWeapon(userId, DBConstants.InUseStatus.InUse);
		if(userWeapons != null && userWeapons.size() > 0){
			Iterator<UserWeapon> iterator = userWeapons.iterator();
			while(iterator.hasNext()){
				//计算武器各个基础数据的数值
				UserWeapon userWeapon = iterator.next();
				int weaponId = userWeapon.getWeaponId();
				int weaponRank = userWeapon.getWeaponRank();
				List<Weapon> ls = weaponMapper.queryWeaponBaseData(null, weaponId, null);
				if(ls != null && ls.size() > 0){
					Weapon w = ls.get(0);
					blood += w.getMaxBlood() + (weaponRank - 1) * w.getMinBlood();
					bloodReply += w.getMaxBloodReply() + (weaponRank - 1) * w.getMinBloodReply();
					baseAttack += w.getMaxBaseAttack() + (weaponRank - 1) * w.getMinBaseAttack();
					attack += w.getMaxAttack() + (weaponRank - 1) * w.getMinAttack();
					shield += w.getMaxShield() + (weaponRank - 1) * w.getMinShield();
					defenseShield += w.getMaxDefenseShield() + (weaponRank - 1) * w.getMinDefenseShield();
					vampire += ((w.getMaxVampire() + (weaponRank - 1) * w.getMinVampire()) * 10);
					critRate += ((w.getMaxCritRate() + (weaponRank - 1) * w.getMinCritRate()) * 10);
					penetrationRate += ((w.getMaxPenetrationRate() + (weaponRank - 1) * w.getMinPenetrationRate()) * 10);
				}
			}
		}
		baseDatas = new ArrayList<BaseData>();
		BaseData baseData1 = new BaseData();
		baseData1.setId(0);
		baseData1.setData(blood);
		BaseData baseData2 = new BaseData();
		baseData2.setId(1);
		baseData2.setData(bloodReply);
		BaseData baseData3 = new BaseData();
		baseData3.setId(2);
		baseData3.setData(baseAttack);
		BaseData baseData4 = new BaseData();
		baseData4.setId(3);
		baseData4.setData(attack);
		BaseData baseData5 = new BaseData();
		baseData5.setId(4);
		baseData5.setData(shield);
		BaseData baseData6 = new BaseData();
		baseData6.setId(5);
		baseData6.setData(defenseShield);
		BaseData baseData7 = new BaseData();
		baseData7.setId(6);
		baseData7.setData(vampire);
		BaseData baseData8 = new BaseData();
		baseData8.setId(7);
		baseData8.setData(critRate);
		BaseData baseData9 = new BaseData();
		baseData9.setId(8);
		baseData9.setData(penetrationRate);
		baseDatas.add(baseData1);
		baseDatas.add(baseData2);
		baseDatas.add(baseData3);
		baseDatas.add(baseData4);
		baseDatas.add(baseData5);
		baseDatas.add(baseData6);
		baseDatas.add(baseData7);
		baseDatas.add(baseData8);
		baseDatas.add(baseData9);
		
		BaseDataView baseDataView = new BaseDataView();
		baseDataView.setBaseDatas(baseDatas);
		return baseDataView;
	}
}
