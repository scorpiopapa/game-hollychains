package com.bt.chains.bean.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "UpdateUserNameForm", description="修改用户名称form")
public class UpdateUserNameForm extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4287958360831630214L;
	
	@ApiObjectField(description = "用户id")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "用户名称")
	@Length(min=1, max=20)
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
