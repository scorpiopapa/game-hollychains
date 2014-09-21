package com.bt.chains.bean.domain;

import java.util.Date;

import com.bt.chains.bean.Product;

public class UserRewardHis extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3778628823282538795L;
	private int id;
	private int userId;
	private int achId;
	private String source;
	private int money;
	private int specialMoney;
	private Date rewardDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAchId() {
		return achId;
	}
	public void setAchId(int achId) {
		this.achId = achId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
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
	public Date getRewardDate() {
		return rewardDate;
	}
	public void setRewardDate(Date rewardDate) {
		this.rewardDate = rewardDate;
	}
}
