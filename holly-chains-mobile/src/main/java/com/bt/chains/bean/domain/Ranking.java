package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class Ranking extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7933191016331655637L;

	int id;
	
	int userId;
	
	int roleId;
	
	int points;

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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
