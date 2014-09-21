package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "UserScoreView", description = "用户保存积分")
public class UserScoreView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6148029650023501937L;
	
	@ApiObjectField(description = "奖励的金币总数=杀怪得到的金币+过关例行奖励的金币")
	int rewardMoney;
	
	@ApiObjectField(description = "用户金币余额")
	int moneyBalance;
	
	@ApiObjectField(description = "用户宝石余额")
	int gemBalance;
	
	@ApiObjectField(description = "奖励的道具名称")
	String propName;
	
	@ApiObjectField(description = "奖励的道具个数")
	int propCount;


	public int getRewardMoney() {
		return rewardMoney;
	}

	public void setRewardMoney(int rewardMoney) {
		this.rewardMoney = rewardMoney;
	}

	public int getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(int moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public int getPropCount() {
		return propCount;
	}

	public void setPropCount(int propCount) {
		this.propCount = propCount;
	}

	public int getGemBalance() {
		return gemBalance;
	}

	public void setGemBalance(int gemBalance) {
		this.gemBalance = gemBalance;
	}
}
