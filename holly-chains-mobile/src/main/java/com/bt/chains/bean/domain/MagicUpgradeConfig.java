package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class MagicUpgradeConfig extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6052398566889070905L;

	int rank;
	
	int money;
	
	int specialMoney;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
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
