package com.bt.chains.bean.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "IntensifyUserMagicForm", description = "魔法强化")
public class IntensifyUserMagicForm extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7404337066269664782L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "魔法ID")
	@Min(1)
	private int magicId;
	
//	@ApiObjectField(description = "魔法级别")
//	private int magicRank;

//	@ApiObjectField(description = "是否付费,0-否，1-是")
//	private String payStatus;

	@ApiObjectField(description = "付费类型,0-金币，1-付费币")
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

	public int getMagicId() {
		return magicId;
	}

	public void setMagicId(int magicId) {
		this.magicId = magicId;
	}

//	public int getMagicRank() {
//		return magicRank;
//	}
//
//	public void setMagicRank(int magicRank) {
//		this.magicRank = magicRank;
//	}
//
//	public String getPayStatus() {
//		return payStatus;
//	}
//
//	public void setPayStatus(String payStatus) {
//		this.payStatus = payStatus;
//	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

//	public int getMoney() {
//		return money;
//	}
//
//	public void setMoney(int money) {
//		this.money = money;
//	}
}
