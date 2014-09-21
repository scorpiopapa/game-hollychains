package com.bt.chains.bean.form;

import java.util.List;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.UserRole;

@Deprecated
@ApiObject(name = "BuyUserRoleForm", description = "购买用户角色", show=false)
public class BuyUserRoleForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -898714558622081879L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "职业列表数据")
	private List<UserRole> roles;
	
	@ApiObjectField(description = "付费类型")
	@NotEmpty
	private String payType;
	
	@ApiObjectField(description = "金额")
	@Min(1)
	private int money;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
