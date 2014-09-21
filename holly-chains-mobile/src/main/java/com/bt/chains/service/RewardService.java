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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bt.chains.bean.domain.GashaWeapon;
import com.bt.chains.bean.domain.OrdinaryCheckPoints;
import com.bt.chains.bean.domain.RewardConfig;
import com.bt.chains.bean.domain.RewardMaster;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserAchievementHistory;
import com.bt.chains.bean.domain.UserProp;
import com.bt.chains.bean.domain.UserRewardHis;
import com.bt.chains.bean.domain.UserRewardStatus;
import com.bt.chains.bean.domain.UserWeapon;
import com.bt.chains.bean.view.ClickToObtainAchivementView;
import com.bt.chains.bean.view.RewardListView;
import com.bt.chains.bean.view.UserAchivementView;
import com.bt.chains.constant.DBConstants;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.constant.DBConstants.RewardType;
import com.bt.chains.constant.DBConstants.RewardValueType;
import com.bt.chains.exception.RequestException;
import com.bt.chains.mapper.CheckpointsMapper;
import com.bt.chains.mapper.RewardMapper;
import com.bt.chains.mapper.UserMapper;
import com.bt.chains.mapper.WeaponMapper;

@Service
public class RewardService {
	private final static Logger log = LoggerFactory.getLogger(RewardService.class);
	
	@Autowired
	private RewardMapper rewardMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WeaponMapper weaponMapper;
	
	@Autowired
	private CheckpointsMapper checkpointsMapper;
	
	@Autowired
	private GameSettingRepository gameSettingRepository;
	
	@Autowired
	UserService userService;
	
	@Transactional(rollbackFor=Exception.class)
	public List<UserAchivementView> getAchivementListDetail(int userId) {
		List<UserAchivementView> userAchivementViewDetail = new ArrayList<UserAchivementView>();
		userAchivementViewDetail = rewardMapper.getAchivementListDetail(userId);
		return userAchivementViewDetail;
	}
	
//	@Transactional(rollbackFor=Exception.class)
//	public RewardListView getAchivementList(int userId) {
//		List<UserAchievementHistory> userAchievementHistoryList = new ArrayList<UserAchievementHistory>();
//		userAchievementHistoryList = rewardMapper.userAchievementHistoryList(userId);
//		
//		List<RewardMaster> rewardMasters = new ArrayList<RewardMaster>();
//		
//		//循环奖励，设置奖励内容
//		if(userAchievementHistoryList != null){
//			Iterator<UserAchievementHistory> iterator = userAchievementHistoryList.iterator();
//			while(iterator.hasNext()){
//				UserAchievementHistory userAchievementHistory = iterator.next();
//				int type = userAchievementHistory.getType();
//				RewardMaster rewardMaster = rewardMapper.getRewardMasterByType(type);
//				String category = "";
//				
//				if(type == 1){
//					//职业驱魔人,登陆内容不用替换
//				}else{
//					//在REWARD_CONFIG表中，根据ID查询CATEGORY
//					RewardConfig rewardConfig = rewardMapper.getRewardConfigById(userAchievementHistory.getRewardId());
//					category = rewardConfig.getCategory();
//					if(type == 3 || type == 4 || type == 5){
//						//涉及到关卡的信息，关卡名称存在客户端，所以直接保存的是关卡ID，需要客户端进行判断
//						rewardMaster.setDescription(category);
//					}else{
//						String description = rewardMaster.getDescription();
//						description = description.replace("{0}", category);
//						rewardMaster.setDescription(description);
//					}
//				}
//				rewardMasters.add(rewardMaster);
//			}
//		}
//		RewardListView rewardListView = new RewardListView();
//		rewardListView.setUserAchievementHistories(userAchievementHistoryList);
//		rewardListView.setRewardMasters(rewardMasters);
//		
//		return rewardListView;
//	}
	
	public List<RewardMaster> getRewardMasterList(int userId, List<UserAchievementHistory> uahList, 
			Map<Integer, RewardMaster> rewardMasterMap,	Map<Integer, Map<Integer, RewardConfig>> rewardConfigMap){
		UserRewardStatus urs = rewardMapper.selectRewardStatus(userId);
		List<RewardMaster> rmList = new ArrayList<RewardMaster>();
		for(UserAchievementHistory urh : uahList){
			int type = urh.getType();
			RewardMaster rm = rewardMasterMap.get(type);
			rmList.add(rm);
			RewardConfig rc = new RewardConfig();
			rc = rewardConfigMap.get(type).get(urh.getRewardId());
			
			if(rc.getMoney()>0){
				rm.setRewardValueType(RewardValueType.money);
				rm.setRewardValue(Integer.toString(rc.getMoney()));
			}else if(rc.getSpecialMoney()>0){
				rm.setRewardValueType(RewardValueType.specialMoney);
				rm.setRewardValue(Integer.toString(rc.getSpecialMoney()));
			}else if(rc.getWeapon()>0){
				rm.setRewardValueType(RewardValueType.weapon);
				rm.setRewardValue(rc.getWeaponName());
				rm.setRewardValueCount(Integer.toString(rc.getWeaponCount()));
			}else if(rc.getProp()>0){
				rm.setRewardValueType(RewardValueType.prop);
				rm.setRewardValue(rc.getPropName());
				rm.setRewardValueCount(Integer.toString(rc.getPropCount()));
			}else if(rc.getOthers()!=null && !rc.getOthers().equals("")){
				rm.setRewardValueType(RewardValueType.strength);
				rm.setRewardValue(rc.getOthers());
			}
			
			String category = rc.getCategory();
			
			String description = rm.getDescription();
			description = description.replace("{0}", String.valueOf(category));
			rm.setDescription(description);
			
			switch(type){
			case RewardType.DailyLogin:
				rm.setRewardSchedule("1/1");
				break;
			case RewardType.LoginSum:
				if(urh.getCompStatus().equals("Y")){
					rm.setRewardSchedule(category + "/" + category);
				}else{
					rm.setRewardSchedule(queryCurrMonthLoginSum(userId)+"/"+category);
				}
				break;
			case RewardType.Common:
			case RewardType.Elite:
			case RewardType.Hero:
				if(urh.getCompStatus().equals("Y")){
					rm.setRewardSchedule("1/1");
				}else{
					rm.setRewardSchedule("0/1");
				}
				break;
			case RewardType.MoneySum:
				if(urh.getCompStatus().equals("Y")){
					rm.setRewardSchedule(category + "/" + category);
				}else{
					rm.setRewardSchedule((urs==null?"0":urs.getMoneySum())+"/"+category);
				}
				break;
			case RewardType.SpecialMoneySum:
				if(urh.getCompStatus().equals("Y")){
					rm.setRewardSchedule(category + "/" + category);
				}else{
					rm.setRewardSchedule((urs==null?"0":urs.getSpecialMoneySum())+"/"+category);
				}
				break;
			case RewardType.Challenge:
				if(urh.getCompStatus().equals("Y")){
					rm.setRewardSchedule(category + "/" + category);
				}else{
					rm.setRewardSchedule((urs==null?"0":urs.getChanlengeSum())+"/"+category);
				}
				break;
			}
		}
		return rmList;
	}
	@Transactional(rollbackFor=Exception.class)
	public RewardListView getAchivementList(int userId) {
		Map<Integer, RewardMaster> rewardMasterMap = getRewardMasterMap();
		Map<Integer, Map<Integer, RewardConfig>> rewardConfigMap = getRewardConfigMap();
		
		RewardListView rewardListView = new RewardListView();
		List<UserAchievementHistory> userAchievementHistoryList = new ArrayList<UserAchievementHistory>();
		userAchievementHistoryList = rewardMapper.userAchievementHistoryList(userId);
		rewardListView.setUserAchievementHistories(userAchievementHistoryList);
		
		List<RewardMaster> rewardMasterList = new ArrayList<RewardMaster>();
		rewardMasterList = getRewardMasterList(userId, userAchievementHistoryList, rewardMasterMap, rewardConfigMap);
		rewardListView.setRewardMasters(rewardMasterList);

		return rewardListView;
	}
	
	public int queryCurrMonthLoginSum(int userId){
		//查询当月登陆天数
		Date date = new Date();//当前日期
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
	
	@Transactional(rollbackFor=Exception.class)
	public int getAchivementCounts(int userId) {
		//查询是否有成就
		int count = rewardMapper.selectCurrentAchievements(userId);
		if(count == 0){
			count = rewardMapper.selectOtherAchievements(userId);
		}
		return count;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public ClickToObtainAchivementView clickToObtainAchivement(int archivementId, int userId) throws RequestException {
		//1. 领取奖励信息，更新奖励领取状态
		UserAchievementHistory uarh = new UserAchievementHistory();
		uarh.setId(archivementId);
		uarh.setCompStatus("Y");
		uarh.setStatus("Y");
		userMapper.updateUserAchievementHistory(uarh);
		
		//2. 将奖励信息插入reward history表中
		//RewardMaster 
		Map<Integer, RewardMaster> rewardMasterMap = getRewardMasterMap();
		//RewardConfig 
		Map<Integer, Map<Integer, RewardConfig>> rewardConfigMap = getRewardConfigMap();
		
		UserAchievementHistory uarDetail = rewardMapper.selectUserAchievementHistory(uarh);
		RewardConfig rcConfig = rewardConfigMap.get(uarDetail.getType()).get(uarDetail.getRewardId());
		
		UserRewardHis rhis = new UserRewardHis();
		rhis.setUserId(userId);
		rhis.setAchId(uarDetail.getId());
		rhis.setSource(rewardMasterMap.get(rcConfig.getRewardType()).getName());
		rhis.setMoney(rcConfig.getMoney());
		rhis.setSpecialMoney(rcConfig.getSpecialMoney());
		rhis.setRewardDate(new Date());
		rewardMapper.inserUserRewardHis(rhis);
		
		int weaponId = rcConfig.getWeapon();
		int weaponCount = rcConfig.getWeaponCount();
		if(weaponCount > 0){
			//判断用户背包容量
			int bagCount = userMapper.selectStoreCount(userId, 1);
			//判断武器仓库容量
			int storeCount = userMapper.selectStoreCount(userId, 0);
			//用户当前背包容量
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
			
			//如果背包容量够大
			if(bagSurplusCount >= weaponCount){
				//返回武器数据
				log.debug("query weapon wids");
				for(int i = 0; i < weaponCount; i++){
					UserWeapon userWeapon = new UserWeapon();
					userWeapon.setUserId(userId);
					userWeapon.setWeaponId(weaponId);
					userWeapon.setWeaponRank(1);
					userWeapon.setBagStatus(1);
					weaponMapper.insertUserWeapon(userWeapon);
				}
			}else{
				//如果背包剩余容量和仓库剩余容量之和大于所获得的武器个数
				if((bagSurplusCount + storeSurplusCount) >= weaponCount){
					//返回武器数据
					log.debug("query weapon wids");
					if(bagSurplusCount > 0){
						for(int i = 0; i < weaponCount; i++){
							UserWeapon userWeapon = new UserWeapon();
							userWeapon.setUserId(userId);
							userWeapon.setWeaponId(weaponId);
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
							UserWeapon userWeapon = new UserWeapon();
							userWeapon.setUserId(userId);
							userWeapon.setWeaponId(weaponId);
							userWeapon.setWeaponRank(1);
							userWeapon.setBagStatus(0);
							weaponMapper.insertUserWeapon(userWeapon);
						}
					}
				}else{
					throw new RequestException(ErrorCodeConstants.NOT_ENOUGH_STROE_ERROR, ErrorCodeConstants.NOT_ENOUGH_STROE_MSG);
				}
			}
			
			for(int i = 0; i < weaponCount; i++){
				UserWeapon userWeapon = new UserWeapon();
				weaponMapper.insertUserWeapon(userWeapon);
				
				
			}
		}
		
		int propId = rcConfig.getProp();
		int propCount = rcConfig.getPropCount();
		//更新道具信息
		if(propCount > 0){
			//更新道具表
			UserProp userProp = new UserProp();
			userProp.setUserId(userId);
			userProp.setPropNum(propCount);
			userProp.setPropId(propId);
			userMapper.updateUserProp(userProp);
		}
		
		//String strength = rcConfig.getOthers();
		//3. 根据金钱数量判断“赏金猎人”， “挖金者”
		int money = rhis.getMoney();
		//如果金币有变动
		if(money > 0){
			//更新用户金币数量
			User u = new User();
			u.setUserId(userId);
			u.setMoney(money);
			userMapper.addUserMoney(u);
			processRewardStatus(userId, RewardType.MoneySum, money);
		}
		int specialMoney = rhis.getSpecialMoney();
		if(specialMoney > 0){
			//更新用户宝石数量
			userMapper.updateAddGem(userId, specialMoney);
			processRewardStatus(userId, RewardType.SpecialMoneySum, specialMoney);
		}
		
		//4. 返回下条奖励信息，并判断下调奖励状态是否为完成状态，如不为完成状态，插入一条“进行中的奖励信息”
		ClickToObtainAchivementView ulv = new ClickToObtainAchivementView();
		List uahList = new ArrayList();
		List rmList = new ArrayList();
		UserAchievementHistory nextUarh = new UserAchievementHistory();
		
		int nextRewardId = uarDetail.getRewardId() + 1;
		RewardConfig rc = rewardConfigMap.get(uarDetail.getType()).get(nextRewardId);
		
		if(uarDetail.getType() != RewardType.DailyLogin && rc!=null){
			nextUarh.setUserId(uarDetail.getUserId());
			nextUarh.setRewardId(nextRewardId);
			UserAchievementHistory next = rewardMapper.selectUserAchievementHistory(nextUarh);
			
			if(next != null)
				uahList.add(next);
			else{
				nextUarh.setCompStatus("N");
				nextUarh.setStatus("N");
				nextUarh.setCreateDate(new Date());
				nextUarh.setType(uarDetail.getType());
				nextUarh.setUpdateDate(new Date());
				userMapper.insertUserAchievementHistory(nextUarh);
				uahList.add(nextUarh);
			}
			rmList = getRewardMasterList(userId, uahList, rewardMasterMap, rewardConfigMap);
			ulv.setRewardMasters(rmList);
			ulv.setUserAchievementHistories(uahList);
		}
		
		User user = userMapper.selectUser(userId);
		ulv.setMoney(user.getMoney());
		ulv.setSpecialMoney(user.getSpecialMoney());
		return ulv;
	}
	
	public void updateRewardStatus(int userId, UserRewardStatus urs){
		urs.setUserId(userId);
		urs.setMoneySum(urs.getMoneySum());
		urs.setSpecialMoneySum(urs.getSpecialMoneySum());
		urs.setChanlengeSum( urs.getChanlengeSum());
		rewardMapper.updateRewardStatus(urs);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int insertCheckPointAchivement(int checkPointId, int userId) {
		List<RewardConfig> rewardConfigList = rewardMapper.getRewardConfig();
		for(RewardConfig rc : rewardConfigList){
			if(!"".equals(rc.getCategory()) && (rc.getRewardType() == RewardType.Common || 
					rc.getRewardType() == RewardType.Elite || rc.getRewardType() == RewardType.Hero)){
				if(Integer.parseInt(rc.getCategory()) == checkPointId){
					int rewardId = rc.getId();
					int type = rc.getRewardType();
					
					List<UserAchievementHistory> ahvList = userMapper.selectUserAchievementHistory(userId, type, null, null, rewardId);
					if(ahvList != null && ahvList.get(0).getCompStatus().equals("N")){
						userService.updateUserAchievementHistory(ahvList.get(0).getId(), "Y", "N");
					}else{
						insertUserAchievementHistory(userId, rewardId, "Y", "N", type);
					}
				}
			}
		}
		return 0;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int insertChallengeAchivement(int compCount, int userId) {
		List<RewardConfig> rewardConfigList = rewardMapper.getRewardConfig();
		for(RewardConfig rc : rewardConfigList){
			if(!"".equals(rc.getCategory()) && rc.getRewardType() == RewardType.Challenge){
				if(Integer.parseInt(rc.getCategory()) == compCount){
					int rewardId = rc.getId();
					int type = rc.getRewardType();
					
					List<UserAchievementHistory> ahvList = userMapper.selectUserAchievementHistory(userId, type, null, null, rewardId);
					if(ahvList != null && ahvList.get(0).getCompStatus().equals("N")){
						userService.updateUserAchievementHistory(ahvList.get(0).getId(), "Y", "N");
					}else{
						insertUserAchievementHistory(userId, rewardId, "Y", "N", type);
					}
				}
			}
		}
		return 0;
	}
	
	public void insertUserAchievementHistory(int userId, int rewardId, String compStatus, String status, int type){
		UserAchievementHistory userAchievementHistory = new UserAchievementHistory();
		userAchievementHistory.setUserId(userId);
		userAchievementHistory.setRewardId(rewardId);
		userAchievementHistory.setCompStatus(compStatus);
		userAchievementHistory.setStatus(status);
		userAchievementHistory.setType(type);
		userAchievementHistory.setCreateDate(new Date());
		userMapper.insertUserAchievementHistory(userAchievementHistory);
	}
	
	public Map<Integer, RewardMaster> getRewardMasterMap(){
		List<RewardMaster> rewardMasterList = rewardMapper.getRewardMaster();
		Map<Integer, RewardMaster> rewardMasterMap = new HashMap<Integer, RewardMaster>();
		for(RewardMaster rm : rewardMasterList){
			rewardMasterMap.put(rm.getType(), rm);
		}
		return rewardMasterMap;
	}
	
	public Map<Integer, Map<Integer, RewardConfig>> getRewardConfigMap(){
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
		return rewardConfigMap;
	}
	
	public Map<Integer, Map<Integer, UserAchievementHistory>> getAchivementHisMap(int userId){
		List<UserAchievementHistory> ahvList = userMapper.selectUserAchievementHistory(userId, null, null, null, null);
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
		return ahvMap;
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
	
	public void processRewardStatus(int userId, int type, int add){
		Map<Integer, Map<Integer, UserAchievementHistory>> ahvMap = getAchivementHisMap(userId);
		Map<Integer, Map<Integer, RewardConfig>> rewardConfigMap = getRewardConfigMap();
		Map<Integer, RewardConfig> sumConfigMap = rewardConfigMap.get(type);
		
		//更新RewardConfigStatus表
		UserRewardStatus currRe = rewardMapper.selectRewardStatus(userId);
		if(currRe == null){
			currRe = new UserRewardStatus();
			currRe.setUserId(userId);
			currRe.setMoneySum(0);
			currRe.setSpecialMoneySum(0);
			currRe.setChanlengeSum(0);
			rewardMapper.insertRewardStatus(currRe);
		}
		
		int sum = 0;
		if(type == RewardType.MoneySum){
			sum = currRe==null?add:currRe.getMoneySum() + add;
			//如果奖励钻石超过用户最大钻石数，不继续累加
			if(sum > DBConstants.User.maxGem){
				sum = DBConstants.User.maxGem;
			}
			currRe.setMoneySum(sum);
		}else if(type == RewardType.SpecialMoneySum){
			
			sum = currRe==null?add:currRe.getSpecialMoneySum() + add;
			currRe.setSpecialMoneySum(sum);
		}else if(type == RewardType.Challenge){
			sum = currRe==null?add:currRe.getChanlengeSum() + add;
			currRe.setChanlengeSum(sum); 
		}
		updateRewardStatus(userId, currRe);
		
		//获得此类奖励最大值，然后判断当前数值是否大约下一次rewardId对应数值
		Map<Integer,UserAchievementHistory> sumAcvMap = ahvMap.get(type);
		if(sumAcvMap == null){
			return;
		}
		int sumMaxKey = getMaxKey(sumAcvMap);
		
		UserAchievementHistory sumAcv = sumAcvMap.get(sumMaxKey);
		int sumRewardId = sumAcv.getRewardId();
		
		//判断是否要插入一条achievement
		if(sumAcv.getCompStatus().equals("N")){
			int category = Integer.parseInt(sumConfigMap.get(sumRewardId).getCategory());
			if(!(category > sum)){
				userService.updateUserAchievementHistory(sumAcv.getId(), "Y", "N");
			}
		}
		
		for(int key : sumConfigMap.keySet()){
			if(key > sumRewardId){
				int nextSum = Integer.parseInt(sumConfigMap.get(key).getCategory());
				if(!(nextSum > sum)){
					insertUserAchievementHistory(userId, sumConfigMap.get(key).getId(), "Y", "N", type);
				}
			}
		}
	}

	public RewardConfig selectCheckPointRewardConfig(int sceneId) {
		List<RewardConfig> rewardConfigList = rewardMapper.getRewardConfig();
		RewardConfig returnConfig = null;
		for(RewardConfig rc : rewardConfigList){
			if(rc.getRewardType()==RewardType.Common || rc.getRewardType()==RewardType.Elite || rc.getRewardType()==RewardType.Hero){
				if(Integer.parseInt(rc.getCategory())==sceneId){
					returnConfig = rc;
					break;
				}
			}
		}
		return returnConfig;
	}

}
