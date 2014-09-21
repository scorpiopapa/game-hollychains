package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "ComposedWeaponView", description = "合成武器返回结果")
public class ComposedWeaponView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8376995747360024257L;

	@ApiObjectField(description = "武器等级")
	int rank;
	
	@ApiObjectField(description = "当前经验值")
	int points;
	
	@ApiObjectField(description = "用户金币余额")
	int moneyBalance;
	
	@ApiObjectField(description = "用户宝石余额")
	int gemBanlance;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(int moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

	public int getGemBanlance() {
		return gemBanlance;
	}

	public void setGemBanlance(int gemBanlance) {
		this.gemBanlance = gemBanlance;
	}
}
