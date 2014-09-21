package com.bt.chains.bean.form;

import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@Deprecated
@ApiObject(name = "BuyGashaForm", description = "购买扭蛋form", show=false)
public class BuyGashaForm extends Product {

	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "购买扭蛋券个数")
	private int gashaNum;
	
	@ApiObjectField(description = "购买扭蛋券类型")
	private int buyType;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGashaNum() {
		return gashaNum;
	}
	public void setGashaNum(int gashaNum) {
		this.gashaNum = gashaNum;
	}

}
