package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.RewardMaster;
import com.bt.chains.bean.domain.UserAchievementHistory;

@ApiObject(name = "RewardListView", description = "返回奖励列表信息")
public class RewardListView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1899115943343146300L;
	
	@ApiObjectField(description = "列表显示相关信息")
	private List<UserAchievementHistory> userAchievementHistories;
	
	@ApiObjectField(description = "列表名称信息")
	private List<RewardMaster> rewardMasters;

	public List<UserAchievementHistory> getUserAchievementHistories() {
		return userAchievementHistories;
	}

	public void setUserAchievementHistories(
			List<UserAchievementHistory> userAchievementHistories) {
		this.userAchievementHistories = userAchievementHistories;
	}

	public List<RewardMaster> getRewardMasters() {
		return rewardMasters;
	}

	public void setRewardMasters(List<RewardMaster> rewardMasters) {
		this.rewardMasters = rewardMasters;
	}
}
