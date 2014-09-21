package com.bt.chains.bean.domain;

import java.util.Date;

import com.bt.chains.bean.Product;

public class UserRewardStatus extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7979208902287367039L;
	private int userId;
	private int pveSum;
	private int pveCount;
	private Date lastPveDate;
	private int moneySum;
	private int specialMoneySum;
	private int chanlengeSum;
	
	public int getPveSum() {
		return pveSum;
	}
	public void setPveSum(int pveSum) {
		this.pveSum = pveSum;
	}
	public int getPveCount() {
		return pveCount;
	}
	public void setPveCount(int pveCount) {
		this.pveCount = pveCount;
	}
	public Date getLastPveDate() {
		return lastPveDate;
	}
	public void setLastPveDate(Date lastPveDate) {
		this.lastPveDate = lastPveDate;
	}
	public int getChanlengeSum() {
		return chanlengeSum;
	}
	public void setChanlengeSum(int chanlengeSum) {
		this.chanlengeSum = chanlengeSum;
	}
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
