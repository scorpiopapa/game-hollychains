package com.bt.chains.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bt.chains.bean.domain.ActivityCheckPoints;
import com.bt.chains.bean.domain.Boss;
import com.bt.chains.bean.domain.Checkpoint;
import com.bt.chains.bean.domain.CheckpointRole;
import com.bt.chains.bean.domain.EliteCheckPoints;
import com.bt.chains.bean.domain.HeroCheckPoints;
import com.bt.chains.bean.domain.LimitLessCheckPoints;
import com.bt.chains.bean.domain.Monster;
import com.bt.chains.bean.domain.OrdinaryCheckPoints;
import com.bt.chains.bean.domain.PlaySmallStageInfoView;
import com.bt.chains.bean.domain.PlayStageInfoView;
import com.bt.chains.bean.domain.Ranking;
import com.bt.chains.bean.domain.RankingRewardConfig;
import com.bt.chains.bean.domain.UnLimitedConfig;
import com.bt.chains.bean.domain.UnlockConfig;
import com.bt.chains.bean.domain.UserFinishedCheckpoint;
import com.bt.chains.bean.domain.UserHellAssignInfo;
import com.bt.chains.bean.domain.UserProp;
import com.bt.chains.bean.view.RankingView;

@Repository
public interface CheckpointsMapper {
	/**
	 * 查询普通关卡信息
	 */
	public OrdinaryCheckPoints queryCheckpoints(@Param("sceneId") int sceneId);
	/**
	 * 查询Boss信息
	 */
	public Boss queryBoss(@Param("bossId") int bossId);
	/**
	 * 查询怪兽信息
	 */
	public Monster queryMonster(@Param("monster") int monsterId);
	
	/**
	 * 查询精英关卡信息
	 */
	public EliteCheckPoints queryEliteCheckpoints(@Param("sceneId") int sceneId);
	/**
	 * 查询英雄关卡信息
	 */
	public HeroCheckPoints queryHeroCheckpoints(@Param("sceneId") int sceneId);
	/**
	 * 查询活动关卡信息
	 */
	public ActivityCheckPoints queryActivityCheckpoints(@Param("sceneId") int sceneId);
	/**
	 * 查询无限关卡信息
	 */
	public LimitLessCheckPoints queryLimitLessCheckpoints(@Param("sceneId") int sceneId);
	/**
	 * 扣除无限模式
	 */
	public int deductionSecurities(UserProp userProp);
	
	/**
	 * 查询无限配置信息
	 * @param id
	 * @return
	 */
	public UnLimitedConfig queryUnLimitedInfo(@Param("id") int id);
	/**
	 * 根据bossIds查询，boss信息
	 */
	public List<Boss> queryBossByIds(@Param("bossIds") List<Integer> bossIds);
	/**
	 * 根据monsterIds查询，Monster信息
	 */
	public List<Monster> queryMonsterByIds(@Param("monsterIds") List<Integer> monsterIds);
	
	/**
	 * 查询大关卡基本信息
	 */
	public List<PlayStageInfoView> queryBigStage(@Param("currentStage") int currentStage,@Param("sceneType") int sceneType);
	
	/**
	 * 查询小关卡基本信息
	 */
	public List<PlaySmallStageInfoView> querySmallStage(@Param("currentStage") int currentStage,@Param("sceneId") int sceneId);
	
	/**
	 * 根据用户ID获取当前关卡ID
	 */
	public String getCurrentStage(@Param("userId") int userId);
	
	/**
	 * 插入用户的炼狱随机角色与武器
	 * @param user
	 * @return int
	 */
	public int insertUserHellAssignInfo(UserHellAssignInfo userHellAssignInfo);
	
	/**
	 * 查询用户的炼狱随机角色与武器信息
	 */
	public List<UserHellAssignInfo> queryUserHellAssignInfo(@Param("userId") String userId);
	
	
	/**
	 * 更新用户职业状态
	 */
	public void updateRoleStatus(@Param("userId") int userId,@Param("roleId") int roleId);
	
	/**
	 * 更新用户金币
	 */
	public void updateUserGold(@Param("userId") int userId,@Param("money") int money);
	
	/**
	 * 职业，魔法解锁信息
	 * @param sceneId
	 * @return
	 */
	UnlockConfig selectUnlockConfig(@Param("sceneId") int sceneId);
	
	Checkpoint selectCheckpointReward(@Param("sceneId") int sceneId);
	
	/**
	 * 插入随机无限模式排名
	 * @param userId
	 * @param roleId
	 * @param points
	 */
	void insertRanking(Ranking ranking);
	
	/**
	 * 插入自定义无限模式排名
	 * @param userId
	 * @param roleId
	 * @param points
	 */
	void insertCustomRanking(Ranking ranking);
	
	List<Integer> selectRankingPoints();
	
	List<Integer> selectCustomRankingPoints();
	
	List<RankingRewardConfig> selectRankingConfig();
	
	List<RankingRewardConfig> selectCustomRankingConfig();
	
	/**
	 * 获取无限模式全服排名信息
	 */
	public RankingView getRanking();
	
	/**
	 * 获取自定义模式的全服排名信息
	 */
	public RankingView getCustomRanking();
	
	/**
	 * 获取无限模式个人排名信息
	 */
	public RankingView getRankingByuser(int userId);
	
	/**
	 * 获取自定义模式的个人排名信息
	 */
	public RankingView getCustomRankingByuser(int userId);
	/**
	 * 查询用户进入无限模式，选择的职业
	 * @param userId
	 * @param type
	 * @return
	 */
	public List<CheckpointRole> queryCheckpointRole(@Param("userId") Integer userId, @Param("type") String type);
	/**
	 * 更新用户进入无限模式，选择的职业
	 * @param checkpointRole
	 */
	public void updateCheckpointRole(CheckpointRole checkpointRole);
	/**
	 * 新增用户进入无限模式，选择的职业
	 * @param checkpointRole
	 */
	public void insertCheckpointRole(CheckpointRole checkpointRole);
	/**
	 * 插入用户通关信息
	 * @param userFinishedCheckpoint
	 */
	@Deprecated
	public void insertFinishCheckpointInfo(UserFinishedCheckpoint userFinishedCheckpoint);
	/**
	 * 查询用户通关信息
	 * @param userFinishedCheckpoint
	 * @return
	 */
	public List<UserFinishedCheckpoint> selectFinishCheckpointInfo(@Param("userId") Integer userId, @Param("sceneId") Integer sceneId);
	/**
	 * 查询普通关卡数据
	 * @return
	 */
	public List<UserFinishedCheckpoint> selectCheckpintList(@Param("userId") int userId);
	/**
	 * 查询精英关卡数据
	 * @return
	 */
	public List<UserFinishedCheckpoint> selectEliteCheckpintList(@Param("userId") int userId);
	/**
	 * 查询英雄关卡数据
	 * @return
	 */
	public List<UserFinishedCheckpoint> selectHeroCheckpintList(@Param("userId") int userId);
	/**
	 * 查询活动关卡数据
	 * @return
	 */
	public List<UserFinishedCheckpoint> selectActivityCheckpintList(@Param("userId") int userId);
}


