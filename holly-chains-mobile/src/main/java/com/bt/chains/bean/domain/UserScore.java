package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

/**
 * 用户积分
 */
public class UserScore extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2106351105673222144L;
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 职业ID
	 */
	private int roleId;
	/**
	 * 用户积分
	 */
	private int score;
	/**
	 * 积分类型，R-随机无限模式积分；C-自定义无限模式积分
	 */
	private String type;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
