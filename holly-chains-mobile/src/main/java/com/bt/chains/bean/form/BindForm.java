package com.bt.chains.bean.form;


import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "BindForm", description="绑定用户数据设备")
public class BindForm extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5739966315299759104L;
	
	@ApiObjectField(description = "目标帐号的用户id")
	@Min(1)
	private int id;
	
	@ApiObjectField(description = "当前设备用户id")
	@Min(1)
	private int userId;
	
//	@ApiObjectField(description = "用户在应用市场的id")
//	@NotEmpty
//	private String marketId;
//
//	@ApiObjectField(description = "市场类型, A-apple;G-google", allowedvalues = {"A", "G"})
//	private String market;
	
	@ApiObjectField(description = "用户事先获得的切换码")
	@Length(min=5,max=5)
	private String code;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getMarketId() {
//		return marketId;
//	}
//
//	public void setMarketId(String marketId) {
//		this.marketId = marketId;
//	}
//
//	public String getMarket() {
//		return market;
//	}
//
//	public void setMarket(String market) {
//		this.market = market;
//	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
