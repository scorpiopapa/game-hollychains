package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "UserMagic", description = "魔法")
public class UserMagic extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8722298647413720773L;
	
	@ApiObjectField(description = "主键")
	private int id;
	/**
	 * 用户ID
	 */
	@ApiObjectField(description = "用户id")
	private int userId;
	/**
	 * 魔法ID
	 */
	@ApiObjectField(description = "魔法id")
	private int magicId;
	/**
	 * 魔法等级
	 */
	@ApiObjectField(description = "魔法等级")
	private int magicRank;
	
	@ApiObjectField(description = "0-非当前魔法;1-当前魔法")
	int inUse;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMagicId() {
		return magicId;
	}
	public void setMagicId(int magicId) {
		this.magicId = magicId;
	}
	public int getMagicRank() {
		return magicRank;
	}
	public void setMagicRank(int magicRank) {
		this.magicRank = magicRank;
	}
	public int getInUse() {
		return inUse;
	}
	public void setInUse(int inUse) {
		this.inUse = inUse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
