package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "LastItem", description = "最后操作的物品信息")
public class LastItem extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3985719219963468264L;
	
	@ApiObjectField(description = "主键")
	private int keyId;
	@ApiObjectField(description = "物品id")
	private int id;
	@ApiObjectField(description = "物品级别")
	private int rank;
	public int getKeyId() {
		return keyId;
	}
	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
