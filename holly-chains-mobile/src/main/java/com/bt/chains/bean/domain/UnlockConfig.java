package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class UnlockConfig extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1942295242069515518L;

	int sceneId;
	
	int roleId;
	
	int magicId;

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getMagicId() {
		return magicId;
	}

	public void setMagicId(int magicId) {
		this.magicId = magicId;
	}
	
	
}
