package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "UserRole", description = "用户角色")
public class UserRole extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8507841885522116747L;
	/**
	 * 用户ID
	 */
	@ApiObjectField(description = "用户ID")
	private int userId;
	/**
	 * 职业ID
	 */
	@ApiObjectField(description = "职业ID")
	private int roleId;
	/**
	 * 职业等级
	 */
	@ApiObjectField(description = "职业等级")
	private int roleRank;

	@ApiObjectField(description = "0-非当前职业;1-当前职业")
	int inUse;
	
	/**
	 * 是否新职业
	 */
	@ApiObjectField(description = "是否新职业  0：新职业   1：非新职业")
	private int isNewRole;
	
	public int getIsNewRole() {
		return isNewRole;
	}
	public void setIsNewRole(int isNewRole) {
		this.isNewRole = isNewRole;
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
	public int getRoleRank() {
		return roleRank;
	}
	public void setRoleRank(int roleRank) {
		this.roleRank = roleRank;
	}
	public int getInUse() {
		return inUse;
	}
	public void setInUse(int inUse) {
		this.inUse = inUse;
	}
}
