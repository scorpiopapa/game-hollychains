package com.bt.chains.bean.domain;

import java.util.Date;

import com.bt.chains.bean.Product;

public class PropBuyHis extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3081627683489084286L;
	
	/**
	 * ID主键
	 */
	private int id;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 道具ID
	 */
	private int propId;
	/**
	 * 购买花费的金额
	 */
	private int specialMoney;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}
	public int getSpecialMoney() {
		return specialMoney;
	}
	public void setSpecialMoney(int specialMoney) {
		this.specialMoney = specialMoney;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
