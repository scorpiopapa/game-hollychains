package com.bt.chains.bean.form;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@Deprecated
@ApiObject(name = "IntensifyUserWeaponForm", description = "武器强化", show=false)
public class IntensifyUserWeaponForm extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8606013597293041797L;
	@ApiObjectField(description = "用户ID")
	private int userId;
	
	@ApiObjectField(description = "武器对应的主键")
	private int id;
	
	@ApiObjectField(description = "武器级别")
	private int weaponRank;

	@ApiObjectField(description = "是否付费,0-否，1-是")
	private String payStatus;

	@ApiObjectField(description = "付费类型,0-银币，1-付费币")
	private String payType;
	
	@ApiObjectField(description = "金额")
	private int money;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeaponRank() {
		return weaponRank;
	}

	public void setWeaponRank(int weaponRank) {
		this.weaponRank = weaponRank;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
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
