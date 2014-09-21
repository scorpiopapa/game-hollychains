package com.bt.chains.bean.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "IntensifyUserRoleForm", description = "职业强化")
public class IntensifyUserRoleForm extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2083156384976611066L;

	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "职业ID")
	@Min(1)
	private int roleId;
	
//	@ApiObjectField(description = "职业级别")
//	private int roleRank;

//	@ApiObjectField(description = "是否付费,0-否，1-是")
//	private String payStatus;

	@ApiObjectField(description = "付费类型,0-银币，1-付费币")
	@Min(0)
	@Max(1)
	private int payType;
	
//	@ApiObjectField(description = "金额")
//	private int money;

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

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

//	public int getRoleRank() {
//		return roleRank;
//	}
//
//	public void setRoleRank(int roleRank) {
//		this.roleRank = roleRank;
//	}
//
//	public String getPayStatus() {
//		return payStatus;
//	}
//
//	public void setPayStatus(String payStatus) {
//		this.payStatus = payStatus;
//	}
//
//	public String getPayType() {
//		return payType;
//	}
//
//	public void setPayType(String payType) {
//		this.payType = payType;
//	}
//
//	public int getMoney() {
//		return money;
//	}
//
//	public void setMoney(int money) {
//		this.money = money;
//	}
}
