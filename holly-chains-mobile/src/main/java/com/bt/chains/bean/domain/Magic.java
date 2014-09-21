package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "Magic", description = "所有魔法")
public class Magic extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6748835802340934230L;
	/**
	 * 魔法ID
	 */
	@ApiObjectField(description = "魔法ID")
	private int magicId;
	/**
	 * 魔法名称
	 */
	@ApiObjectField(description = "魔法名称")
	private String magicName;

	public int getMagicId() {
		return magicId;
	}

	public void setMagicId(int magicId) {
		this.magicId = magicId;
	}

	public String getMagicName() {
		return magicName;
	}

	public void setMagicName(String magicName) {
		this.magicName = magicName;
	}

}
