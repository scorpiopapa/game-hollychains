package com.bt.chains.bean.domain;

import java.util.Date;
import java.util.List;

import com.bt.chains.bean.Product;

public class GashaHis extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2627587028687253960L;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 武器个数
	 */
	private int gashaNum;
	/**
	 * 付费币
	 */
	private String specialMoney;
	/**
	 * 添加时间
	 */
	private String opTime;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getGashaNum() {
		return gashaNum;
	}
	public void setGashaNum(int gashaNum) {
		this.gashaNum = gashaNum;
	}
	public String getSpecialMoney() {
		return specialMoney;
	}
	public void setSpecialMoney(String specialMoney) {
		this.specialMoney = specialMoney;
	}
	public String getOpTime() {
		return opTime;
	}
	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

}
