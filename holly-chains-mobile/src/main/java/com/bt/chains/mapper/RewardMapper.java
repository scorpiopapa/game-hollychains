package com.bt.chains.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bt.chains.bean.domain.RewardConfig;
import com.bt.chains.bean.domain.RewardMaster;
import com.bt.chains.bean.domain.UserAchievementHistory;
import com.bt.chains.bean.domain.UserReward;
import com.bt.chains.bean.domain.UserRewardHis;
import com.bt.chains.bean.domain.UserRewardStatus;
import com.bt.chains.bean.domain.UserScore;
import com.bt.chains.bean.view.UserAchivementView;

@Repository
public interface RewardMapper {
	/**
	 * 获取用户奖励信息
	 * @param int
	 * @return UserRewardView
	 */
	public List<UserAchivementView> getAchivementListDetail(@Param("userId")int userId);
	/**
	 * 获取成就种类
	 * @param int
	 * @return UserRewardView
	 */
	public List<RewardMaster> getRewardMaster();
	/**
	 * 获取成就详情
	 * @param int
	 * @return UserRewardView
	 */
	public List<RewardConfig> getRewardConfig();
	/**
	 * 获取成就列表
	 * @param int
	 * @return UserRewardView
	 */
	public List<UserAchievementHistory> userAchievementHistoryList(@Param("userId")int userId);
	/**
	 * 查询当日成就
	 * @param UserMagic
	 * @return
	 */
	public int selectCurrentAchievements(@Param("userId")int userId);
	
	/**
	 * 查询其他成就
	 * @param UserMagic
	 * @return
	 */
	public int selectOtherAchievements(@Param("userId")int userId);
	/**
	 * 获取成就信息
	 * @param int
	 * @return UserAchievementHistory
	 */
	public UserAchievementHistory selectUserAchievementHistory(
			UserAchievementHistory uarh);
	
	/**
	 * 插入用户成就（有关money）
	 * @param user
	 * @return
	 */
	public void inserUserRewardHis(UserRewardHis rhis);
	
	/**
	 * 查询用户成就状态
	 * @param user
	 * @return
	 */
	public UserRewardStatus selectRewardStatus(int userId);
	/**
	 * 插入用户成就状态
	 * @param user
	 * @return
	 */
	public void insertRewardStatus(UserRewardStatus urs);
	
	/**
	 * 更新用户成就状态
	 * @param user
	 * @return
	 */
	public void updateRewardStatus(UserRewardStatus urs);
	/**
	 * 获取用户可以获取的奖励
	 * @return
	 */
	public RewardConfig queryUserReward(@Param("category")int category, @Param("rewardType")int rewardType);
	/**
	 * 根据类型获取奖励信息
	 * @param type
	 * @return
	 */
	public RewardMaster getRewardMasterByType(@Param("type")int type);
	/**
	 * 根据ID获取奖励配置信息
	 * @param id
	 * @return
	 */
	public RewardConfig getRewardConfigById(@Param("id")int id);
	/**
	 * 查询本月登陆天数
	 * @param userId
	 * @param minMonthDate
	 * @param nextMinMonthDate
	 * @return int
	 */
	public int queryCurrMonthLoginSum(@Param("userId")int userId, @Param("type")int type, @Param("minMonthDate")String minMonthDate,
			@Param("nextMinMonthDate")String nextMinMonthDate);
}
