package com.bt.chains.bean.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.constant.RegexConstants;

@ApiObject(name = "EnterCustomCheckpointForm", description = "进入自定义无限关卡")
public class EnterCustomCheckpointForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3186742005906261843L;

	@ApiObjectField(description = "用户id")
	@Min(1)
	int userId;
	
	@ApiObjectField(description = "扣除类型，0-付费币；1-无限券")
	@Pattern(regexp=RegexConstants.PAY_TYPE)
	private String payType;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

}
