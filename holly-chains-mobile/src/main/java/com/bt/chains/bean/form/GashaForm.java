package com.bt.chains.bean.form;

import java.util.List;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.UserMagic;

@Deprecated
@ApiObject(name = "GashaForm", description = "抽取扭蛋form", show=false)
public class GashaForm extends Product {

	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "抽取扭蛋个数")
	private int getGashaNum;
	
	@ApiObjectField(description = "购买扭蛋次数")
	private int buyGashaNum;
	
	@ApiObjectField(description = "购买扭蛋类别（扭蛋券/钻石）")
	private int buyGashaType;
	
	@ApiObjectField(description = "购买扭蛋付费币")
	private int specialMoney;
	
	public int getSpecialMoney() {
		return specialMoney;
	}
	public void setSpecialMoney(int specialMoney) {
		this.specialMoney = specialMoney;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGetGashaNum() {
		return getGashaNum;
	}
	public void setGetGashaNum(int getGashaNum) {
		this.getGashaNum = getGashaNum;
	}
	public int getBuyGashaNum() {
		return buyGashaNum;
	}
	public void setBuyGashaNum(int buyGashaNum) {
		this.buyGashaNum = buyGashaNum;
	}
	public int getBuyGashaType() {
		return buyGashaType;
	}
	public void setBuyGashaType(int buyGashaType) {
		this.buyGashaType = buyGashaType;
	}
   
}
