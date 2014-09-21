package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class ProductConfig extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7482332476639874478L;

	String productId;
	
	int gemNumber;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getGemNumber() {
		return gemNumber;
	}

	public void setGemNumber(int gemNumber) {
		this.gemNumber = gemNumber;
	}
	
}
