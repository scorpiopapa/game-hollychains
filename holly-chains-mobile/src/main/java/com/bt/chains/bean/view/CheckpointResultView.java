package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "CheckpointResultView", description = "普通，精英，英雄，活动关卡结束后用户获得的奖励")
public class CheckpointResultView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5257829770088345990L;
	
	@ApiObjectField(description = "解锁的职业id，如果没有解锁的职业为0")
	int roleId;
	
	@ApiObjectField(description = "解锁的魔法id，如果没有解锁的职业为0")
	int magicId;

	@ApiObjectField(description = "奖励的金币总数=杀怪得到的金币+过关例行奖励的金币")
	int money;
	
	@ApiObjectField(description = "用户金币余额")
	int moneyBalance;
	
	@ApiObjectField(description = "奖励武器的状态")
	List<RewardWeaponStatus> rewardWeaponStatus;
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getMagicId() {
		return magicId;
	}

	public void setMagicId(int magicId) {
		this.magicId = magicId;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(int moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

	public List<RewardWeaponStatus> getRewardWeaponStatus() {
		return rewardWeaponStatus;
	}

	public void setRewardWeaponStatus(List<RewardWeaponStatus> rewardWeaponStatus) {
		this.rewardWeaponStatus = rewardWeaponStatus;
	}
	
}
