package com.bt.chains.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bt.chains.bean.domain.ActivityCheckPoints;
import com.bt.chains.bean.domain.BaseData;
import com.bt.chains.bean.domain.Boss;
import com.bt.chains.bean.domain.Checkpoint;
import com.bt.chains.bean.domain.CheckpointRole;
import com.bt.chains.bean.domain.EliteCheckPoints;
import com.bt.chains.bean.domain.HeroCheckPoints;
import com.bt.chains.bean.domain.LimitLessCheckPoints;
import com.bt.chains.bean.domain.Magic;
import com.bt.chains.bean.domain.Monster;
import com.bt.chains.bean.domain.OrdinaryCheckPoints;
import com.bt.chains.bean.domain.Param;
import com.bt.chains.bean.domain.PlaySmallStageInfoView;
import com.bt.chains.bean.domain.PlayStageInfoView;
import com.bt.chains.bean.domain.RewardConfig;
import com.bt.chains.bean.domain.Role;
import com.bt.chains.bean.domain.RoleBaseData;
import com.bt.chains.bean.domain.UnLimitedConfig;
import com.bt.chains.bean.domain.UnlockConfig;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserAchievementHistory;
import com.bt.chains.bean.domain.UserFinishedCheckpoint;
import com.bt.chains.bean.domain.UserHellAssignInfo;
import com.bt.chains.bean.domain.UserHellAssignView;
import com.bt.chains.bean.domain.UserMagic;
import com.bt.chains.bean.domain.UserProp;
import com.bt.chains.bean.domain.UserRole;
import com.bt.chains.bean.domain.UserScore;
import com.bt.chains.bean.domain.UserWeapon;
import com.bt.chains.bean.domain.Weapon;
import com.bt.chains.bean.form.CheckpointsForm;
import com.bt.chains.bean.form.EnterCheckpointForm;
import com.bt.chains.bean.form.EnterUnLimitedCheckpointForm;
import com.bt.chains.bean.view.CheckpointResultView;
import com.bt.chains.bean.view.CheckpointsView;
import com.bt.chains.bean.view.PlayStageListView;
import com.bt.chains.bean.view.RankingListView;
import com.bt.chains.bean.view.RankingView;
import com.bt.chains.bean.view.RewardWeaponStatus;
import com.bt.chains.constant.DBConstants;
import com.bt.chains.constant.DBConstants.RewardType;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.mapper.CheckpointsMapper;
import com.bt.chains.mapper.MagicMapper;
import com.bt.chains.mapper.RoleMapper;
import com.bt.chains.mapper.UserMapper;
import com.bt.chains.mapper.WeaponMapper;
import com.bt.chains.repository.WeaponRepository;

@Service
public class CheckpointsService {
	private final static Logger log = LoggerFactory
			.getLogger(CheckpointsService.class);
	
//	final static int UNLIMIT_CHECKPOINT1 = 1401;
	
	@Autowired
	private CheckpointsMapper checkpointsMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MagicMapper magicMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	@Autowired WeaponRepository weaponRepository;
	
	@Autowired WeaponMapper weaponMapper;
	
	@Autowired
	private RewardService rewardService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private GameSettingRepository gameSettingRepository;
	/**
	 * 查询大小关卡基本信息
	 * 
	 * @param sceneId
	 * @param sceneType
	 * @return
	 */
//	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = Exception.class)
	public PlayStageListView queryStageInfo(int userId) {
//		List<PlayStageInfoView> playStageInfoViewList = null;
//		List<PlaySmallStageInfoView> playSmallStageInfoViewlist = null;
		PlayStageListView playstagelist = new PlayStageListView();
		 List<PlayStageInfoView> playStageInfos = new ArrayList<>();
		//根据用户ID获取当前关卡
//		int currentStage = 0;
		// 先查询大关卡信息，然后查询小关卡信息
//		List StageList = new ArrayList();
		UserHellAssignView userHellRandomInfo =new UserHellAssignView();
		   for(int i=0;i<=4;i++){
//			 playStageInfoViewList = checkpointsMapper.queryBigStage(currentStage,i);
//			 if(!CollectionUtils.isEmpty(playStageInfoViewList)){
//				 for(int j=0;j<playStageInfoViewList.size();j++){
//					 PlayStageInfoView infoView = playStageInfoViewList.get(j);
//					 //查询小关卡信息
//					 playSmallStageInfoViewlist = checkpointsMapper.querySmallStage(currentStage, infoView.getStage1Id());
//					 if(!CollectionUtils.isEmpty(playSmallStageInfoViewlist)){
//						 infoView.setPlaySmallStageInfoViewList(playSmallStageInfoViewlist);
//					 }
//				 }
//			 }
			   
			 //普通关卡
			 if(i == 0){
				 List<UserFinishedCheckpoint> list = checkpointsMapper.selectCheckpintList(userId);
				 List<PlayStageInfoView> views = getPlayStageInfoView(list, i);
				 playStageInfos.addAll(views);
			 }
			 //精英关卡
			 else if(i == 1){
				 List<UserFinishedCheckpoint> list = checkpointsMapper.selectEliteCheckpintList(userId);
				 List<PlayStageInfoView> views = getPlayStageInfoView(list, i);
				 playStageInfos.addAll(views);
			 }
			 //英雄关卡
			 else if(i == 2){
				 List<UserFinishedCheckpoint> list = checkpointsMapper.selectHeroCheckpintList(userId);
				 List<PlayStageInfoView> views = getPlayStageInfoView(list, i);
				 playStageInfos.addAll(views);
			 }
			//无限关卡
			 else if(i == 3){
				 // ****** 以下代码目的只是保证客户端解析正确，客户端不会使用里边的数据，所以都设成假数据 *******
				 PlayStageInfoView hellView = new PlayStageInfoView();
				 hellView.setStage1Id(14);
				 hellView.setStage1Name("");
				 hellView.setSceneType(3);
				 hellView.setPalyedFlag(0);
				 
				 List<PlaySmallStageInfoView> subViews = new ArrayList<>();
				 PlaySmallStageInfoView randomSubView = new PlaySmallStageInfoView();
				 randomSubView.setStage2Id(1401);
				 randomSubView.setStage2Name("");
				 randomSubView.setPalyedFlag(0);
				 randomSubView.setStamina(0);
				 subViews.add(randomSubView);
				 
				 PlaySmallStageInfoView customSubView = new PlaySmallStageInfoView();
				 customSubView.setStage2Id(1501);
				 customSubView.setStage2Name("");
				 customSubView.setStamina(0);
				 customSubView.setPalyedFlag(0);
				 subViews.add(customSubView);
				 
				 hellView.setPlaySmallStageInfoViewList(subViews);
				 
				 playStageInfos.add(hellView);
				// ****** 假数据设置结束 *******
			 }
			 //活动关卡
			 else if(i == 4){
				 List<UserFinishedCheckpoint> list = checkpointsMapper.selectActivityCheckpintList(userId);
				 List<PlayStageInfoView> views = getPlayStageInfoView(list, i);
				 playStageInfos.addAll(views);
			 }
//			 StageList.addAll(playStageInfoViewList);
			 //炼狱模式 开始随机获取3个职业和15个武器，10个魔法,个数暂定。。
			 if(i==4){
//				 List<String> weaponList=new ArrayList<String>();
				 List<String> roleList=new ArrayList<String>();
				 List<String> magicList=new ArrayList<String>();
				 List<UserHellAssignInfo> queryUserHellAssignInfo = checkpointsMapper.queryUserHellAssignInfo(String.valueOf(userId));
				 if(queryUserHellAssignInfo!=null&&queryUserHellAssignInfo.size()>0){
					//暂时只考虑一条记录的情况 TODO
					  UserHellAssignInfo obj=queryUserHellAssignInfo.get(0);
					  String  randomRole=obj.getRandomRole();
					  String randomWeapon=obj.getRandomWeapon();
					  String randonMagic = obj.getRandomMagic();
					  userHellRandomInfo.setRolelist(handleRandomData(randomRole));
					  
					  List<Param> ids = handleRandomData(randomWeapon);
					  userHellRandomInfo.setWeaponsFirstLine(ids.subList(0, 5));
					  userHellRandomInfo.setWeaponsSecondLine(ids.subList(5, 10));
					  userHellRandomInfo.setWeaponsThridLine(ids.subList(10, 15));
					  
//					  userHellRandomInfo.setWeaponList(handleRandomData(randomWeapon));
					  
					  userHellRandomInfo.setMagicList(handleRandomData(randonMagic));
				 }
				 //用户没有随机生成的职业与武器，开始随机处理
				 else{
				    List<Role> alljobs=userMapper.selectAllJobs();
				    List<Weapon> weapons=userMapper.selectAllWeapons(null);
				    String weaponListIntoDatabase=null;
				    List<Param> weaponsFirstLine=new ArrayList<>();
				    List<Param> weaponsSecondLine=new ArrayList<>();
				    List<Param> weaponsThridLine=new ArrayList<>();
				    List<Magic> magics=userMapper.selectAllMagics();
				    if(!CollectionUtils.isEmpty(alljobs)){
//				    	rolelist =  
				    	for(Role jobobj:alljobs){
				    		if(jobobj!=null){
					    		String roleIdstr = String.valueOf(jobobj.getJobId());
					    		roleList.add(roleIdstr);
				    		}
				    		//construct return rolelist to database
				    	}
				    	//随机取得3个职业 暂定 数字可以改变
			    		if(roleList!=null){
			    			userHellRandomInfo.setRolelist(getRandomNum(roleList,3));
			    		}
				    }
				    if(!CollectionUtils.isEmpty(magics)){
				    	for(Magic magicobj:magics){
				    		if(magicobj!=null){
					    		String magicStr = String.valueOf(magicobj.getMagicId());
					    		magicList.add(magicStr);
				    		}
				    		//construct return rolelist to database
				    	}
				    	//随机取得10个魔法 暂定 数字可以改变
			    		if(magicList!=null){
			    			userHellRandomInfo.setMagicList(getRandomNum(magicList,10));
			    		}
				    }
				    if(!CollectionUtils.isEmpty(weapons)){
//				    	weaponList =  new ArrayList<String>();
//				    	for(Weapon weapon:weapons){
//				    		if(weapon!=null){
//				    			weaponList.add(String.valueOf(weapon.getWeaponId()));
//				    		}
//				    		//construct return weaponlist to database
//				    	}
//				    	//随机取得5个武器 暂定 数字可以改变
//			    		if(weaponList!=null){
//			    			userHellRandomInfo.setWeaponList(getRandomNum(weaponList,15));
//			    		}
			    		//获取穿透率1-5的武器 随机三个
			    		for(int j=1;j<=5;j++){
			    			 List<Weapon> currentRareWeapons = userMapper.selectAllWeapons(j);
			    			 currentRareWeapons = getWeaponRandomNum(currentRareWeapons,3);
			    			 if(currentRareWeapons!=null){
			    				 weaponsFirstLine.add(new Param(currentRareWeapons.get(0).getWid()));
			    				 weaponsSecondLine.add(new Param(currentRareWeapons.get(1).getWid()));
			    				 weaponsThridLine.add(new Param(currentRareWeapons.get(2).getWid()));
			    			 }
			    		}
			    		weaponListIntoDatabase = gethellWeaponDataStucture(weaponsFirstLine)+gethellWeaponDataStucture(weaponsSecondLine)+gethellWeaponDataStucture(weaponsThridLine);
			    		userHellRandomInfo.setWeaponsFirstLine(weaponsFirstLine);
			    		userHellRandomInfo.setWeaponsSecondLine(weaponsSecondLine);
			    		userHellRandomInfo.setWeaponsThridLine(weaponsThridLine);
				    }
				    //保存随机生成的用户炼狱数据
				    if(!CollectionUtils.isEmpty(alljobs)&&!CollectionUtils.isEmpty(weapons)){
				    	UserHellAssignInfo userHellAssignInfo = new UserHellAssignInfo();
					    userHellAssignInfo.setUserId(userId);
					    userHellAssignInfo.setRandomRole(gethellDataStucture(userHellRandomInfo.getRolelist()));
					    userHellAssignInfo.setRandomWeapon(weaponListIntoDatabase);
					    userHellAssignInfo.setRandomMagic(gethellDataStucture(userHellRandomInfo.getMagicList()));
					    userHellAssignInfo.setCreateDate(new Date());
					    try{
					    checkpointsMapper.insertUserHellAssignInfo(userHellAssignInfo);
					    }catch(Exception e){
					    	e.printStackTrace();
					    }
				    }
				 }
				 
			 }
			 
		   }
		   
		   List<UserHellAssignView> hellView = new ArrayList<>();
		   hellView.add(userHellRandomInfo);
		   playstagelist.setUserHellRandomInfo(hellView);
		   
		   if(!CollectionUtils.isEmpty(playStageInfos)){
			   for(PlayStageInfoView v : playStageInfos){
				   Collections.sort(v.getPlaySmallStageInfoViewList(), new Comparator<PlaySmallStageInfoView>(){
					@Override
					public int compare(PlaySmallStageInfoView v1, PlaySmallStageInfoView v2) {
						return v2.getStage2Id() - v1.getStage2Id();
					}
				   });
			   }
		   }
		   
		   playstagelist.setPlayStageInfos(playStageInfos);
		return playstagelist;
	}
	
	List<PlayStageInfoView> getPlayStageInfoView(List<UserFinishedCheckpoint> list, int type){
		List<PlayStageInfoView> views = new ArrayList<>();
		
		if(!CollectionUtils.isEmpty(list)){
			// key - 大关卡id, value-大关卡下的小关卡列表
			Map<Integer, List<UserFinishedCheckpoint>> points = new TreeMap<>(new Comparator<Integer>(){
				@Override
				public int compare(Integer i1, Integer i2) {
					return i1 - i2;
				}
			});
			
			//按照大关卡分组
			for(UserFinishedCheckpoint p : list){
				List<UserFinishedCheckpoint> subPoints = null;
				
				int key = p.getCheckpointId() / 100;
				
				if(points.containsKey(key)){
					subPoints = points.get(key);
				}else{
					subPoints = new ArrayList<>();
					points.put(key, subPoints);
				}
				subPoints.add(p);
			}
			
			views = buildPlayStageInfoView(points, type);
			
//			Collections.sort(views, new Comparator<PlayStageInfoView>(){
//				@Override
//				public int compare(PlayStageInfoView arg0, PlayStageInfoView arg1) {
//					return 0;
//				}
//			});
		}else{
			// 尚未通过任何关卡
			Checkpoint cp = null;
			
			if(type == 0){
				cp = checkpointsMapper.queryCheckpoints(1001);
			}else if(type == 1){
				cp = checkpointsMapper.queryEliteCheckpoints(1101);
			}else if(type == 2){
				cp = checkpointsMapper.queryHeroCheckpoints(1201);
			}else if(type == 3){
				cp = checkpointsMapper.queryActivityCheckpoints(1301);
			}
			
			if(cp != null){
				PlaySmallStageInfoView subView = new PlaySmallStageInfoView();
				subView.setStage2Id(cp.getSceneId());
				subView.setStage2Name(StringUtils.trimToEmpty(cp.getSmallStage()));
				subView.setPalyedFlag(1);
				subView.setStamina(cp.getPower());
				
				PlayStageInfoView view = new PlayStageInfoView();
				view.setStage1Id(cp.getSceneId() / 100);
				view.setStage1Name(StringUtils.trimToEmpty(cp.getBigStage()));
				view.setSceneType(type);
				view.setPalyedFlag(1);
				
				List<PlaySmallStageInfoView> subViews = new ArrayList<>();
				subViews.add(subView);
				
				view.setPlaySmallStageInfoViewList(subViews);
				
				views.add(view);
			}

		}
		
		return views;
	}
	
	List<PlayStageInfoView> buildPlayStageInfoView(Map<Integer, List<UserFinishedCheckpoint>> points, int type){
		List<PlayStageInfoView> views = new ArrayList<>();
		
		int lastSceneId;
		List<PlaySmallStageInfoView> lastSubViews = null;
		PlayStageInfoView lastView = null;
		
		Iterator<Integer> keys = points.keySet().iterator();
		while(keys.hasNext()){
			int key = keys.next();
			
			List<UserFinishedCheckpoint> list = points.get(key);
			
			PlayStageInfoView view = new PlayStageInfoView();
			view.setStage1Id(key);
			view.setStage1Name(StringUtils.trimToEmpty(list.get(0).getBigStage()));
			view.setSceneType(type);
			view.setPalyedFlag(0);
			
			List<PlaySmallStageInfoView> subViews = new ArrayList<>();
			for(UserFinishedCheckpoint p : list){
				PlaySmallStageInfoView subView = new PlaySmallStageInfoView();
				subView.setStage2Id(p.getCheckpointId());
				subView.setStage2Name(StringUtils.trimToEmpty(p.getSmallStage()));
				subView.setPalyedFlag(0);
				subView.setStamina(p.getPower());
				
				subViews.add(subView);
			}
			
			view.setPlaySmallStageInfoViewList(subViews);
			views.add(view);
			
			lastView = view;
			lastSubViews = subViews;
		}
		
		lastSceneId = lastSubViews.get(lastSubViews.size() - 1).getStage2Id() + 1;
		
		Checkpoint cp = null;
		
		if(type == 0){
			cp = checkpointsMapper.queryCheckpoints(lastSceneId);
		}else if(type == 1){
			cp = checkpointsMapper.queryEliteCheckpoints(lastSceneId);
		}else if(type == 2){
			cp = checkpointsMapper.queryHeroCheckpoints(lastSceneId);
		}else if(type == 3){
			cp = checkpointsMapper.queryActivityCheckpoints(lastSceneId);
		}
		
		if(cp != null){
			// 仍有未完成的小关卡
			PlaySmallStageInfoView subView = new PlaySmallStageInfoView();
			subView.setStage2Id(cp.getSceneId());
			subView.setStage2Name(StringUtils.trimToEmpty(cp.getSmallStage()));
			subView.setPalyedFlag(1);
			subView.setStamina(cp.getPower());
			
			lastSubViews.add(subView);
			
			lastView.setPalyedFlag(1);
		}else{
			// 所有小关卡都已完成, 添加下一个大关卡的小关卡
			PlayStageInfoView view = new PlayStageInfoView();
			view.setPalyedFlag(1);
			
			lastView.setPalyedFlag(0);
			
			lastSceneId = lastSceneId / 100 + 10;
			lastSceneId = lastSceneId * 100 + 1;
			
			if(type == 0){
				cp = checkpointsMapper.queryCheckpoints(lastSceneId);
			}else if(type == 1){
				cp = checkpointsMapper.queryEliteCheckpoints(lastSceneId);
			}else if(type == 2){
				cp = checkpointsMapper.queryHeroCheckpoints(lastSceneId);
			}else if(type == 3){
				cp = checkpointsMapper.queryActivityCheckpoints(lastSceneId);
			}

			if(cp != null){
				// 仍有未完成的小关卡
				PlaySmallStageInfoView subView = new PlaySmallStageInfoView();
				subView.setStage2Id(cp.getSceneId());
				subView.setStage2Name(StringUtils.trimToEmpty(cp.getSmallStage()));
				subView.setPalyedFlag(1);
				subView.setStamina(cp.getPower());
				
				List<PlaySmallStageInfoView> subViews = new ArrayList<>();
				subViews.add(subView);
				
				view.setStage1Id(lastSceneId / 100);
				view.setStage1Name(StringUtils.trimToEmpty(cp.getBigStage()));
				view.setPalyedFlag(1);
				view.setPlaySmallStageInfoViewList(subViews);
				
				views.add(view);
			}else{
				// 所有大卡都已完成
				view.setPalyedFlag(0);
			}
			
		}

		return views;
	}
	
	/**
     * 返回随机数
     * @param randomDataList 采样数据
     * @param selected 选择数据个数
     * @return
     */
    public static List<Param> getRandomNum(List<String> list, int selected) {
        List<Param> reList = new ArrayList<>();
        Random random = new Random();
        if (list.size() >= selected) {
            for (int i = 0; i < selected; i++) {
                int target = random.nextInt(list.size());
                reList.add(new Param(list.get(target)));
                list.remove(target);
            }
        } else {
            selected = list.size();
            for (int i = 0; i < selected; i++) {
                int target = random.nextInt(list.size());
                reList.add(new Param(list.get(target)));
                list.remove(target);
            }
        }
        return reList;
    }
    
	/**
     * 返回武器随机数
     * @param randomDataList 采样数据
     * @param selected 选择数据个数
     * @return
     */
    public static List<Weapon> getWeaponRandomNum(List<Weapon> list, int selected) {
        List<Weapon> reList = new ArrayList<Weapon>();
        Random random = new Random();
        if (list.size() >= selected) {
            for (int i = 0; i < selected; i++) {
                int target = random.nextInt(list.size());
                reList.add(list.get(target));
                list.remove(target);
            }
        } else {
            selected = list.size();
            for (int i = 0; i < selected; i++) {
                int target = random.nextInt(list.size());
                reList.add(list.get(target));
                list.remove(target);
            }
        }
        return reList;
    }
    public String gethellDataStucture(List<Param> list){
    	String returnData="";
    	if(!CollectionUtils.isEmpty(list)){
    		for(Param str:list){
    			returnData+=str.getId()+",";
    		}
    	}
    	return returnData;
    }
    public String gethellWeaponDataStucture(List<Param> list){
    	String returnData="";
    	if(!CollectionUtils.isEmpty(list)){
    		for(Param str:list){
    			returnData+=str.getId()+",";
    		}
    	}
    	return returnData;
    }
	public List<Param> handleRandomData(String arrayData){
		List<Param> hellData = new ArrayList<>();
		if(!StringUtils.isEmpty(arrayData)){
			String[] hellDataArr = arrayData.split(",");
			if(hellDataArr!=null){
				for(int i=0;i<hellDataArr.length;i++){
					hellData.add(new Param(Integer.valueOf(hellDataArr[i])));
				}
			}
		}
		return hellData;
	}
	@Transactional(rollbackFor = Exception.class)
	public CheckpointsView queryCheckpoints(int sceneId, int sceneType) {
		Checkpoint checkpoints = null;
		List<Boss> bossList = null;
		List<Monster> monsterList = null;
		// 普通关卡
		if (sceneType == 0) {
			checkpoints = checkpointsMapper.queryCheckpoints(sceneId);

		}
		// 精英关卡
		else if (sceneType == 1) {
			checkpoints = checkpointsMapper.queryEliteCheckpoints(sceneId);
		}
		// 英雄关卡
		else if (sceneType == 2) {
			checkpoints = checkpointsMapper.queryHeroCheckpoints(sceneId);
		}
//		// 无限关卡
		else if (sceneType == 4) {
			checkpoints = checkpointsMapper.queryLimitLessCheckpoints(sceneId);
		}
		// 活动关卡
		else {
			checkpoints = checkpointsMapper.queryActivityCheckpoints(sceneId);
		}

		CheckpointsView checkpointsView = new CheckpointsView();

		if (checkpoints != null) {
			// 查询boss信息
			bossList = queryBoss(checkpoints, sceneType);
			checkpointsView.setBossList(bossList);
			monsterList = queryMonsters(checkpoints, sceneType);
			checkpointsView.setMonsterList(monsterList);
		}
		checkpointsView.setCheckpoints(checkpoints);

		return checkpointsView;
	}

	@Transactional(rollbackFor = Exception.class)
	public CheckpointsView enterCheckpoint(
			EnterCheckpointForm enterCheckpointForm) throws RequestException {
		int userId = enterCheckpointForm.getUserId();
		int power = enterCheckpointForm.getPower();
		int sceneId = enterCheckpointForm.getSceneId();
		int sceneType = enterCheckpointForm.getSceneType();

		// 体力不够，抛出异常
		User u = userMapper.queryUserByUserId(userId);
		
		if(u == null){
			throw new RequestException(ErrorCodeConstants.ROLE_NO_EXISTS,
					ErrorCodeConstants.ROLE_NO_EXISTS_MSG);
		}
		
//		int uPower = u.getPower();
//		if (uPower < power) {
//			throw new RequestException(ErrorCodeConstants.NOT_ENOUGH_POWER,
//					ErrorCodeConstants.NOT_ENOUGH_POWER_MSG);
//		}

		// 查询关卡信息
		CheckpointsView checkpointsView = queryCheckpoints(sceneId, sceneType);
		
		//计算基础数据值
		List<BaseData> baseDatas = null;
		int blood = 0, bloodReply = 0, baseAttack = 0, attack = 0, shield = 0, defenseShield = 0, vampire = 0, 
				critRate = 0, penetrationRate = 0;
		UserRole userRole = roleMapper.queryRole(userId, null, DBConstants.InUseStatus.InUse);
		int roleId = userRole.getRoleId();
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
		
		checkpointsView.setBaseDatas(baseDatas);
		
		// 扣除用户体力
		User user = new User();
		user.setUserId(userId);
		user.setPower(power);
		userMapper.depletePower(user);
		
		//更新用户职业状态
		checkpointsMapper.updateRoleStatus(userId,roleId);
		
		return checkpointsView;
	}

	@Transactional(rollbackFor = Exception.class)
	public CheckpointsView enterUnLimitedCheckpoint(
			EnterUnLimitedCheckpointForm enterUnLimitedCheckpointForm)
			throws RequestException {
		String type = enterUnLimitedCheckpointForm.getType();
		int userId = enterUnLimitedCheckpointForm.getUserId();
		String deductionType = enterUnLimitedCheckpointForm.getDeductionType();
		int sceneId = enterUnLimitedCheckpointForm.getSceneId();
		int roleId;

		UnLimitedConfig unLimitedConfig = null;
		// 随机
		if ("R".equals(type)) {
			unLimitedConfig = checkpointsMapper.queryUnLimitedInfo(1);
		}
		// 自定义
		else if ("C".equals(type)) {
			unLimitedConfig = checkpointsMapper.queryUnLimitedInfo(2);
		}
		
		if(!"2".equals(deductionType)){
			if ("0".equals(deductionType)) {
				User u = userMapper.queryUserByUserId(userId);
				int specialMoney = u.getSpecialMoney();
				if (specialMoney < unLimitedConfig.getSpecialMoney()) {
					throw new RequestException(ErrorCodeConstants.NOT_ENOUGH_MONEY,
							ErrorCodeConstants.NOT_ENOUGH_MONEY_MSG);
				}

				// 扣除相应的付费币
				User user = new User();
				user.setUserId(userId);
				user.setSpecialMoney(unLimitedConfig.getSpecialMoney());
				userMapper.updateUserSpecialMoney(user);
			} else {
				// 判断用户无限券是否充足
				UserProp up = userMapper.queryUserPropByType(userId, DBConstants.UserProp.UnlimitCheckpointTicket);
				if (up == null
						|| up.getPropNum() < unLimitedConfig
								.getUnlimitedSecuritiesNum()) {
					throw new RequestException(
							ErrorCodeConstants.NOT_ENOUGH_UNLIMITED_SECURITIES,
							ErrorCodeConstants.NOT_ENOUGH_UNLIMITED_SECURITIES_MSG);
				}

				// 扣除相应的无限卷
				UserProp userProp = new UserProp();
				userProp.setUserId(userId);
				// 道具类型4为无限券
				userProp.setPropType(String.valueOf(DBConstants.UserProp.UnlimitCheckpointTicket));
				userProp.setPropNum(unLimitedConfig.getUnlimitedSecuritiesNum());
				checkpointsMapper.deductionSecurities(userProp);
			}
		}
		
		//计算基础数据值
		List<BaseData> baseDatas = null;
		int blood = 0, bloodReply = 0, baseAttack = 0, attack = 0, shield = 0, defenseShield = 0, vampire = 0, 
				critRate = 0, penetrationRate = 0;
		if("R".equals(type)){
			roleId = enterUnLimitedCheckpointForm.getRoleId();
//			UserRole ur = roleMapper.queryRole(userId, roleId, null);
//			if(ur != null){
				RoleBaseData roleBaseData = roleMapper.selectRoleBaseData(roleId, 1);
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
//			}
			List<Param> weaponIds = enterUnLimitedCheckpointForm.getWeaponIds();
			if(weaponIds != null && weaponIds.size() > 0){
				//随即武器默认为1级
				int weaponRank = 1;
				for(int i = 0; i < weaponIds.size(); i++){
					int weaponId = ((Param) weaponIds.get(i)).getId();
					
					List<Weapon> ls = weaponMapper.queryWeaponBaseData(null, null, weaponId);
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
		}
		//自定义
		else{
			UserRole userRole = roleMapper.queryRole(userId, null, DBConstants.InUseStatus.InUse);
			roleId = userRole.getRoleId();
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
		
		//插入当前用户选择的职业ID
		List<CheckpointRole> list = checkpointsMapper.queryCheckpointRole(userId, type);
		if(list != null && list.size() > 0){
			CheckpointRole checkpointRole = list.get(0);
			checkpointRole.setRoleId(roleId);
			checkpointsMapper.updateCheckpointRole(checkpointRole);
		}else{
			CheckpointRole checkpointRole = new CheckpointRole();
			checkpointRole.setUserId(userId);
			checkpointRole.setType(type);
			checkpointRole.setRoleId(roleId);
			checkpointsMapper.insertCheckpointRole(checkpointRole);
		}
		
		// 查询关卡信息
		CheckpointsView checkpointsView = queryCheckpoints(sceneId, 4);
		
		checkpointsView.setBaseDatas(baseDatas);
		
		User user = userMapper.selectUser(userId);
		checkpointsView.setMoney(user.getMoney());
		checkpointsView.setSpecialMoney(user.getSpecialMoney());

		return checkpointsView;
	}

	/**
	 * 查询boss信息
	 * 
	 * @param checkpoints
	 * @param sceneType
	 * @return
	 */
	public List<Boss> queryBoss(Checkpoint checkpoints, int sceneType) {
		List<Boss> bosses = null;
		List<Integer> bossIds = new ArrayList<Integer>();
		// 普通关卡
		if (sceneType == 0) {
			OrdinaryCheckPoints ordinaryCheckPoints = (OrdinaryCheckPoints) checkpoints;
			int bossId1 = ordinaryCheckPoints.getBoss1Id();
			int bossId2 = ordinaryCheckPoints.getBoss2Id();
			int bossId3 = ordinaryCheckPoints.getBoss3Id();
			int bossId4 = ordinaryCheckPoints.getBoss4Id();
			int bossId5 = ordinaryCheckPoints.getBoss5Id();
			int bossId6 = ordinaryCheckPoints.getBoss6Id();
			int bossId7 = ordinaryCheckPoints.getBoss7Id();
			int bossId8 = ordinaryCheckPoints.getBoss8Id();
			bossIds.add(bossId1);
			bossIds.add(bossId2);
			bossIds.add(bossId3);
			bossIds.add(bossId4);
			bossIds.add(bossId5);
			bossIds.add(bossId6);
			bossIds.add(bossId7);
			bossIds.add(bossId8);
			// 查询boss信息
			bosses = checkpointsMapper.queryBossByIds(bossIds);
			
			for(int i = 0; i < bosses.size(); i++){
				int bId = bosses.get(i).getBossId();
				if(bId == bossId1){
					bosses.get(i).setBossRate(ordinaryCheckPoints.getBoss1Rate());
				}else if(bId == bossId2){
					bosses.get(i).setBossRate(ordinaryCheckPoints.getBoss2Rate());
				}else if(bId == bossId3){
					bosses.get(i).setBossRate(ordinaryCheckPoints.getBoss3Rate());
				}else if(bId == bossId4){
					bosses.get(i).setBossRate(ordinaryCheckPoints.getBoss4Rate());
				}else if(bId == bossId5){
					bosses.get(i).setBossRate(ordinaryCheckPoints.getBoss5Rate());
				}else if(bId == bossId6){
					bosses.get(i).setBossRate(ordinaryCheckPoints.getBoss6Rate());
				}else if(bId == bossId7){
					bosses.get(i).setBossRate(ordinaryCheckPoints.getBoss7Rate());
				}else if(bId == bossId8){
					bosses.get(i).setBossRate(ordinaryCheckPoints.getBoss8Rate());
				}
			}
		}
		// 精英关卡
		else if (sceneType == 1) {
			EliteCheckPoints eliteCheckPoints = (EliteCheckPoints) checkpoints;
			int bossId1 = eliteCheckPoints.getBoss1Id();
			int bossId2 = eliteCheckPoints.getBoss2Id();
			int bossId3 = eliteCheckPoints.getBoss3Id();
			int bossId4 = eliteCheckPoints.getBoss4Id();
			int bossId5 = eliteCheckPoints.getBoss5Id();
			int bossId6 = eliteCheckPoints.getBoss6Id();
			int bossId7 = eliteCheckPoints.getBoss7Id();
			int bossId8 = eliteCheckPoints.getBoss8Id();
			bossIds.add(bossId1);
			bossIds.add(bossId2);
			bossIds.add(bossId3);
			bossIds.add(bossId4);
			bossIds.add(bossId5);
			bossIds.add(bossId6);
			bossIds.add(bossId7);
			bossIds.add(bossId8);
			// 查询boss信息
			bosses = checkpointsMapper.queryBossByIds(bossIds);
			
			for(int i = 0; i < bosses.size(); i++){
				int bId = bosses.get(i).getBossId();
				if(bId == bossId1){
					bosses.get(i).setBossRate(eliteCheckPoints.getBoss1Rate());
				}else if(bId == bossId2){
					bosses.get(i).setBossRate(eliteCheckPoints.getBoss2Rate());
				}else if(bId == bossId3){
					bosses.get(i).setBossRate(eliteCheckPoints.getBoss3Rate());
				}else if(bId == bossId4){
					bosses.get(i).setBossRate(eliteCheckPoints.getBoss4Rate());
				}else if(bId == bossId5){
					bosses.get(i).setBossRate(eliteCheckPoints.getBoss5Rate());
				}else if(bId == bossId6){
					bosses.get(i).setBossRate(eliteCheckPoints.getBoss6Rate());
				}else if(bId == bossId7){
					bosses.get(i).setBossRate(eliteCheckPoints.getBoss7Rate());
				}else if(bId == bossId8){
					bosses.get(i).setBossRate(eliteCheckPoints.getBoss8Rate());
				}
			}
		}
		// 英雄关卡
		else if (sceneType == 2) {
			HeroCheckPoints heroCheckPoints = (HeroCheckPoints) checkpoints;
			int bossId1 = heroCheckPoints.getBoss1Id();
			int bossId2 = heroCheckPoints.getBoss2Id();
			int bossId3 = heroCheckPoints.getBoss3Id();
			int bossId4 = heroCheckPoints.getBoss4Id();
			int bossId5 = heroCheckPoints.getBoss5Id();
			int bossId6 = heroCheckPoints.getBoss6Id();
			int bossId7 = heroCheckPoints.getBoss7Id();
			int bossId8 = heroCheckPoints.getBoss8Id();
			bossIds.add(bossId1);
			bossIds.add(bossId2);
			bossIds.add(bossId3);
			bossIds.add(bossId4);
			bossIds.add(bossId5);
			bossIds.add(bossId6);
			bossIds.add(bossId7);
			bossIds.add(bossId8);
			// 查询boss信息
			bosses = checkpointsMapper.queryBossByIds(bossIds);
			
			for(int i = 0; i < bosses.size(); i++){
				int bId = bosses.get(i).getBossId();
				if(bId == bossId1){
					bosses.get(i).setBossRate(heroCheckPoints.getBoss1Rate());
				}else if(bId == bossId2){
					bosses.get(i).setBossRate(heroCheckPoints.getBoss2Rate());
				}else if(bId == bossId3){
					bosses.get(i).setBossRate(heroCheckPoints.getBoss3Rate());
				}else if(bId == bossId4){
					bosses.get(i).setBossRate(heroCheckPoints.getBoss4Rate());
				}else if(bId == bossId5){
					bosses.get(i).setBossRate(heroCheckPoints.getBoss5Rate());
				}
			}
		}
		// 活动关卡
		else if (sceneType == 3) {
			ActivityCheckPoints activityCheckPoints = (ActivityCheckPoints) checkpoints;
			int bossId1 = activityCheckPoints.getBoss1Id();
			int bossId2 = activityCheckPoints.getBoss2Id();
			int bossId3 = activityCheckPoints.getBoss3Id();
			int bossId4 = activityCheckPoints.getBoss4Id();
			int bossId5 = activityCheckPoints.getBoss5Id();
			bossIds.add(bossId1);
			bossIds.add(bossId2);
			bossIds.add(bossId3);
			bossIds.add(bossId4);
			bossIds.add(bossId5);
			// 查询boss信息
			bosses = checkpointsMapper.queryBossByIds(bossIds);
			
			for(int i = 0; i < bosses.size(); i++){
				int bId = bosses.get(i).getBossId();
				if(bId == bossId1){
					bosses.get(i).setBossRate(activityCheckPoints.getBoss1Rate());
				}else if(bId == bossId2){
					bosses.get(i).setBossRate(activityCheckPoints.getBoss2Rate());
				}else if(bId == bossId3){
					bosses.get(i).setBossRate(activityCheckPoints.getBoss3Rate());
				}else if(bId == bossId4){
					bosses.get(i).setBossRate(activityCheckPoints.getBoss4Rate());
				}else if(bId == bossId5){
					bosses.get(i).setBossRate(activityCheckPoints.getBoss5Rate());
				}
			}
		}
		// 无限关卡
		else {
			LimitLessCheckPoints limitLessCheckPoints = (LimitLessCheckPoints) checkpoints;
			int bossId1 = limitLessCheckPoints.getBoss1Id();
			int bossId2 = limitLessCheckPoints.getBoss2Id();
			int bossId3 = limitLessCheckPoints.getBoss3Id();
			int bossId4 = limitLessCheckPoints.getBoss4Id();
			int bossId5 = limitLessCheckPoints.getBoss5Id();
			int bossId6 = limitLessCheckPoints.getBoss6Id();
			int bossId7 = limitLessCheckPoints.getBoss7Id();
			int bossId8 = limitLessCheckPoints.getBoss8Id();
			int bossId9 = limitLessCheckPoints.getBoss9Id();
			int bossId10 = limitLessCheckPoints.getBoss10Id();
			int bossId11 = limitLessCheckPoints.getBoss11Id();
			int bossId12 = limitLessCheckPoints.getBoss12Id();
			int bossId13 = limitLessCheckPoints.getBoss13Id();
			int bossId14 = limitLessCheckPoints.getBoss14Id();
			int bossId15 = limitLessCheckPoints.getBoss15Id();
			int bossId16 = limitLessCheckPoints.getBoss16Id();
			int bossId17 = limitLessCheckPoints.getBoss17Id();
			int bossId18 = limitLessCheckPoints.getBoss18Id();
			int bossId19 = limitLessCheckPoints.getBoss19Id();
			int bossId20 = limitLessCheckPoints.getBoss20Id();
			bossIds.add(bossId1);
			bossIds.add(bossId2);
			bossIds.add(bossId3);
			bossIds.add(bossId4);
			bossIds.add(bossId5);
			bossIds.add(bossId6);
			bossIds.add(bossId7);
			bossIds.add(bossId8);
			bossIds.add(bossId9);
			bossIds.add(bossId10);
			bossIds.add(bossId11);
			bossIds.add(bossId12);
			bossIds.add(bossId13);
			bossIds.add(bossId14);
			bossIds.add(bossId15);
			bossIds.add(bossId16);
			bossIds.add(bossId17);
			bossIds.add(bossId18);
			bossIds.add(bossId19);
			bossIds.add(bossId20);
			// 查询boss信息
			bosses = checkpointsMapper.queryBossByIds(bossIds);
			
			for(int i = 0; i < bosses.size(); i++){
				int bId = bosses.get(i).getBossId();
				if(bId == bossId1){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss1Rate());
				}else if(bId == bossId2){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss2Rate());
				}else if(bId == bossId3){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss3Rate());
				}else if(bId == bossId4){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss4Rate());
				}else if(bId == bossId5){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss5Rate());
				}else if(bId == bossId6){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss6Rate());
				}else if(bId == bossId7){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss7Rate());
				}else if(bId == bossId8){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss8Rate());
				}else if(bId == bossId9){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss9Rate());
				}else if(bId == bossId10){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss10Rate());
				}else if(bId == bossId11){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss11Rate());
				}else if(bId == bossId12){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss12Rate());
				}else if(bId == bossId13){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss13Rate());
				}else if(bId == bossId14){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss14Rate());
				}else if(bId == bossId15){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss15Rate());
				}else if(bId == bossId16){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss16Rate());
				}else if(bId == bossId17){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss17Rate());
				}else if(bId == bossId18){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss18Rate());
				}else if(bId == bossId19){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss18Rate());
				}else if(bId == bossId20){
					bosses.get(i).setBossRate(limitLessCheckPoints.getBoss18Rate());
				}
			}
		}
		return bosses;
	}

	/**
	 * 查询小怪信息
	 * 
	 * @param checkpoints
	 * @param sceneType
	 * @return
	 */
	public List<Monster> queryMonsters(Checkpoint checkpoints, int sceneType) {
		List<Monster> monsters = null;
		List<Integer> monsterIds = new ArrayList<Integer>();

		int monster1Id = checkpoints.getMonster1Id();
		int monster2Id = checkpoints.getMonster2Id();
		int monster3Id = checkpoints.getMonster3Id();
		monsterIds.add(monster1Id);
		monsterIds.add(monster2Id);
		monsterIds.add(monster3Id);

		// TODO 以下代码是判断不同的关卡增加不同的小怪
		// 普通关卡
//		if (sceneType == 0) {
//
//		}
//		// 精英关卡
//		else if (sceneType == 1) {
//
//		}
//		// 英雄关卡
//		else if (sceneType == 2) {
//
//		}
//		// 活动关卡
//		else if (sceneType == 3) {
//
//		}
//		// 无限关卡
//		else {
//        
//		}

		monsters = checkpointsMapper.queryMonsterByIds(monsterIds);
		return monsters;
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	public CheckpointResultView finishCheckpoints(CheckpointsForm form) {
		CheckpointResultView view = new CheckpointResultView();

		// 设置解锁的职业和魔法
		UnlockConfig config = checkpointsMapper.selectUnlockConfig(form.getSceneId());
//		if(config != null){
//			view.setRoleId(config.getRoleId());
//			view.setMagicId(config.getMagicId());
//		}
		
		// 保存用户解锁的魔法和职业，初始化为1级,普通关卡SCENE_CONFIG，精英关卡ELITE_SCENE_CONFIG，英雄关卡HERO_SCENE_CONFIG，活动关卡ACTIVITY_SCENE_CONFIG
		if(config.getMagicId() > 0){
			// 有可解锁的魔法
			List<UserMagic> magics = magicMapper.queryeMagic(form.getUserId(), config.getMagicId(), null);
			if(CollectionUtils.isEmpty(magics)){
				// 用户没有这个魔法
				UserMagic userMagic = new UserMagic();
				userMagic.setMagicId(config.getMagicId());
				userMagic.setUserId(form.getUserId());
				userMagic.setMagicRank(1);
				magicMapper.insertUserMagic(userMagic);
				
				view.setMagicId(config.getMagicId());
			}
		}
		
		if(config.getRoleId() > 0){
			// 有可解锁的职业
			UserRole userRole = roleMapper.queryRole(form.getUserId(), config.getRoleId(), null);
			if(userRole == null){
				// 有可解锁的职业
				userRole = new UserRole();
				userRole.setUserId(form.getUserId());
				userRole.setRoleId(config.getRoleId());
				userRole.setRoleRank(1);
				roleMapper.insertUserRole(userRole);
				
				view.setRoleId(config.getRoleId());
			}
		}
		
		// 根据关卡id查找用户奖励的金币和武器序号,武器序号参见WEAPON.WID
		List<Weapon> weapons = userMapper.selectAllWeapons(null);
		Checkpoint point = checkpointsMapper.selectCheckpointReward(form.getSceneId());
		// 用户获得的金币总数为杀怪金币数+过关奖励金币数
		int money = point.getRewardCoin() + form.getMoney();
		
		view.setMoney(money);
		
		List<RewardWeaponStatus> rewardWeaponStatus = new ArrayList<>();
		
		for(Weapon w : weapons){
			int weaponId = w.getWeaponId();
			int wid = Integer.valueOf(w.getWid());
			
			RewardWeaponStatus status = new RewardWeaponStatus();
			
			// 更新用户武器
			if(weaponId == point.getRewardWeapon1()){
				status.setWid(wid);
				status.setWeaponId(point.getRewardWeapon1());
				status.setNewWeapon(isNewWeapon(form.getUserId(), wid));
				rewardWeaponStatus.add(status);
				
			}else if(weaponId == point.getRewardWeapon2()){
				status.setWid(wid);
				status.setWeaponId(point.getRewardWeapon2());
				status.setNewWeapon(isNewWeapon(form.getUserId(), wid));
				rewardWeaponStatus.add(status);
	
			}else if(weaponId == point.getRewardWeapon3()){
				status.setWid(wid);
				status.setWeaponId(point.getRewardWeapon3());
				status.setNewWeapon(isNewWeapon(form.getUserId(), wid));
				rewardWeaponStatus.add(status);

			}else if(weaponId == point.getRewardWeapon4()){
				status.setWid(wid);
				status.setWeaponId(point.getRewardWeapon4());
				status.setNewWeapon(isNewWeapon(form.getUserId(), wid));
				rewardWeaponStatus.add(status);
			}
			
		}	
		
		saveRewardWeapons(form.getUserId(), rewardWeaponStatus);
		
		view.setRewardWeaponStatus(rewardWeaponStatus);
		
		//更新用户金币
		checkpointsMapper.updateUserGold(form.getUserId(), money);
		
		User user = userMapper.selectUser(form.getUserId());
		view.setMoneyBalance(user.getMoney());
		
		//更新“赏金猎人”信息
		rewardService.processRewardStatus(form.getUserId(), RewardType.MoneySum, money);
		//插入“关卡”archivement
		RewardConfig rc = rewardService.selectCheckPointRewardConfig(form.getSceneId());
		if(rc != null){
			List<UserAchievementHistory> ahvList = userMapper.selectUserAchievementHistory(form.getUserId(), rc.getRewardType(), null, null, rc.getId());
			if(!CollectionUtils.isEmpty(ahvList) && ahvList.get(0).getCompStatus().equals("N")){
				userService.updateUserAchievementHistory(ahvList.get(0).getId(), "Y", "N");
			}else{
				rewardService.insertUserAchievementHistory(form.getUserId(), rc.getId(), "Y", "N", rc.getRewardType());
			}
		}
		
		//保存用户通关信息
		//查询用户通关信息，如果有，不进行任何操作，如果没有插入数据
		UserFinishedCheckpoint userFinishedCheckpoint = new UserFinishedCheckpoint();
		userFinishedCheckpoint.setUserId(form.getUserId());
		userFinishedCheckpoint.setCheckpointId(form.getSceneId());
		List<UserFinishedCheckpoint> list = checkpointsMapper.selectFinishCheckpointInfo(form.getUserId(), form.getSceneId());
		if(!(list != null && list.size() > 0)){
			checkpointsMapper.insertFinishCheckpointInfo(userFinishedCheckpoint);
		}
		
		return view;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public RankingListView getRanking(String type, int mode,int userId, int page) {
		RankingListView view = new RankingListView();
		List<RankingView> rankingViews = new ArrayList<RankingView>();
		List<UserScore> userScoreList = null;
		//个人排名
		if(mode == 0){
			userScoreList = userMapper.queryUserScore(userId, type);
		}
		//全服排名
		else if(mode == 1){
			int num = 100;
			int start = page * num - num;
			int end = page * num;
			userScoreList = userMapper.queryAllUserScore(type, start, end);
			
			int count = userMapper.selectUserScoreCount(type);
			int tailCount = count - page * num;
			int tailPages = 0;
			if(tailCount > 0){
				tailPages = (tailCount / num) + (tailCount % num);
			}
			view.setTailPages(tailPages);
		}
		
		if(userScoreList != null && userScoreList.size() > 0){
			Iterator<UserScore> iterator = userScoreList.iterator();
			int order = 1;
			
			while(iterator.hasNext()){
				UserScore us = iterator.next();
				RankingView rankingView = new RankingView();
				rankingView.setOrder(order);
				rankingView.setName(us.getUserName());
				rankingView.setRoleId(us.getRoleId());
				rankingView.setScore(us.getScore());
				rankingViews.add(rankingView);
				order++;
			}
		}
		view.setRankingViews(rankingViews);
		return view;
	}
	
//	/**
//	 * 查看用户武器仓库还有多少会满
//	 * @param userId
//	 * @return 0表示已满
//	 */
//	int getWeaponRepositoryDelt(int userId, List<UserWeapon> userWeapons, UserProp prop){
//		int repoCount = 0;
//		for(UserWeapon w : userWeapons){
//			if(w.getBagStatus() == 0){
//				// 在仓库中
//				repoCount++;
//			}
//		}
//		
//		return prop.getPropNum() - repoCount;
//	}
	
	void saveUserWeapon(int userId, int weaponId, int bagStatus){
		UserWeapon uw = new UserWeapon();
		uw.setUserId(userId);
		uw.setWeaponId(weaponId);
		uw.setWeaponRank(1);
		uw.setBagStatus(bagStatus);
		weaponMapper.insertUserWeapon(uw);
	}
	
	
	private void saveRewardWeapons(int userId, List<RewardWeaponStatus> rewardWeaponStatus){
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
		
		// 检查武器仓库是否已满，如果已满则丢弃奖励的武器
		// 保存用户武器
		for(RewardWeaponStatus status : rewardWeaponStatus){
			if(bagSurplusCount > 0){
				saveUserWeapon(userId, status.getWeaponId(), 1);
				bagSurplusCount--;
			}else if(storeSurplusCount > 0){
				saveUserWeapon(userId, status.getWeaponId(), 0);
				storeSurplusCount--;
			}else{
				status.setDropped(true);
			}
		}
	}
	
	boolean isNewWeapon(int userId, int wid){
		List<UserWeapon> weapons = weaponMapper.queryWeapon(wid, userId, null);
		
		return weapons == null || weapons.size() == 0;
	}
}
