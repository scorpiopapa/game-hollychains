package com.bt.chains.bean.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.constant.RegexConstants;

@ApiObject(name = "LoginForm", description = "用户登录")
public class LoginForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1056274847217485228L;

	@ApiObjectField(description = "用户在应用市场的id")
//	@NotBlank
	@Length(max=45)
	private String id;
	
	@ApiObjectField(description = "市场类型, A-apple;G-google", allowedvalues = {"A", "G"})
	@Pattern(regexp=RegexConstants.MARKET)
	private String market;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}
}
