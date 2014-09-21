package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "ActiveCode", description = "设备绑定校验")
public class ActiveCode extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -126950567107840383L;
	
	@ApiObjectField(description = "校验码")
	private String activeCode;

	public String getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
}
