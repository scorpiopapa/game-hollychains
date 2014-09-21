package com.bt.chains.bean.domain;

import java.util.Date;

import com.bt.chains.bean.Product;

public class UserAuth extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2373535364455878579L;
	/**
	 * 主键
	 */
	private int sId;
	/**
	 * 用户ID
	 */
	private int userId;
	
	/**
	 * 绑定到的用户id
	 */
	int bindUserId;
	
	/**
	 * 切换码
	 */
	private String code;
	/**
	 * 过期标志
	 */
	private String expired;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getBindUserId() {
		return bindUserId;
	}
	public void setBindUserId(int expiredUserId) {
		this.bindUserId = expiredUserId;
	}
}
