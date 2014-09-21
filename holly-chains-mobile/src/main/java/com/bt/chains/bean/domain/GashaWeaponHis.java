package com.bt.chains.bean.domain;

import java.util.Date;
import java.util.List;

import com.bt.chains.bean.Product;

public class GashaWeaponHis extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2627587028687253960L;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 武器ID
	 */
	private int weaponId;
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
	public int getWeaponId() {
		return weaponId;
	}
	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}
	public String getOpTime() {
		return opTime;
	}
	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

}
