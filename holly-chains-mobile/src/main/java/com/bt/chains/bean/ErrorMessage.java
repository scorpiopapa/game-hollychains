package com.bt.chains.bean;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(name = "ErrorMessage", description = "服务器错误对象")
public class ErrorMessage extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3749861173022800956L;

	@ApiObjectField(description = "错误码")
	private String code;
	
	@ApiObjectField(description = "错误描述")
	private String message;

	public ErrorMessage(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
