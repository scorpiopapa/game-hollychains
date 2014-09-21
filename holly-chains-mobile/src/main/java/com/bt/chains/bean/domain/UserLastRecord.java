package com.bt.chains.bean.domain;

import java.util.Date;

import com.bt.chains.bean.Product;

//@ApiObject(name = "UserLastRecords", description = "最后一次用户选择的信息")
public class UserLastRecord extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1107308856059183095L;
	/**
	 * 用户ID
	 */
//	@ApiObjectField(description = "用户ID")
//	@Min(1)
	private int userId;
	/**
	 * 用户最后一次持有的（武器、魔法、职业）ID
	 */
//	@ApiObjectField(description = "用户最后一次持有的（武器、魔法、职业）ID")
//	@Min(1)
	private int id;
	/**
	 * 类型：0：职业；1：武器；2：魔法
	 */
//	@ApiObjectField(description = "类型：0：职业；1：武器；2：魔法")
//	@Min(0)
	private int type;
	/**
	 * 操作时间
	 */
//	@ApiObjectField(description = "opTime")
	private Date opTime;
	/**
	 * 等级
	 */
//	@ApiObjectField(description = "等级")
	private int rank;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getOpTime() {
		return opTime;
	}
	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
