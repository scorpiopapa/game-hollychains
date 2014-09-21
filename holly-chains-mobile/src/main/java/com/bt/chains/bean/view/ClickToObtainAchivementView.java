package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.RewardMaster;
import com.bt.chains.bean.domain.UserAchievementHistory;

@ApiObject(name = "RewardListView", description = "返回奖励列表信息")
public class ClickToObtainAchivementView extends com.joinway.bean.view.View{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2190145672802580368L;

	@ApiObjectField(description = "列表显示相关信息")
	private List<UserAchievementHistory> userAchievementHistories;
	
	@ApiObjectField(description = "列表名称信息")
	private List<RewardMaster> rewardMasters;
	
	@ApiObjectField(description = "金币")
	private int money;
	
	@ApiObjectField(description = "宝石")
	private int specialMoney;

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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getSpecialMoney() {
		return specialMoney;
	}

	public void setSpecialMoney(int specialMoney) {
		this.specialMoney = specialMoney;
	}
}

