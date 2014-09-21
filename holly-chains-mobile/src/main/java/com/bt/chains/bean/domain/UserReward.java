package com.bt.chains.bean.domain;

import java.util.Date;

import com.bt.chains.bean.Product;

public class UserReward extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6133838345050879634L;

	int userId;
	
	int moneySum;
	
	int specialMoneySum;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMoneySum() {
		return moneySum;
	}

	public void setMoneySum(int moneySum) {
		this.moneySum = moneySum;
	}

	public int getSpecialMoneySum() {
		return specialMoneySum;
	}

	public void setSpecialMoneySum(int specialMoneySum) {
		this.specialMoneySum = specialMoneySum;
	}
	
}
