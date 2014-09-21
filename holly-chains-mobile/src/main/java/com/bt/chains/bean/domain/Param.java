package com.bt.chains.bean.domain;


import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "Param", description = "id信息")
public class Param extends Product{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4591315653723414376L;
	
	public Param(){}
	
	public Param(int id) {
		this.id = id;
	}

	public Param(String id) {
		this.id = Integer.valueOf(id);
	}

	@ApiObjectField(description = "标识用id")
	@Min(1)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
