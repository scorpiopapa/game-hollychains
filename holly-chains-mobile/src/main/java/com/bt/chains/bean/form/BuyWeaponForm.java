package com.bt.chains.bean.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.constant.RegexConstants;

@ApiObject(name = "BuyWeaponForm", description = "购买武器传入参数")
public class BuyWeaponForm extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3883488149713800658L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	@ApiObjectField(description = "gashaId")
	@Min(1)
	private int gashaId;
	@ApiObjectField(description = "购买类型，G-宝石；T-武器制造券")
	@Pattern(regexp=RegexConstants.BUY_TYPE)
	private String buyType;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGashaId() {
		return gashaId;
	}
	public void setGashaId(int gashaId) {
		this.gashaId = gashaId;
	}
	public String getBuyType() {
		return buyType;
	}
	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}
}
