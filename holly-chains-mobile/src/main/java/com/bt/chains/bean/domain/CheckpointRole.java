package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class CheckpointRole extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 726133300414984079L;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 进入关卡类型： R-随机模式 , C-自定义模式
	 */
	private String type;
	/**
	 * 职业ID
	 */
	private int roleId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
