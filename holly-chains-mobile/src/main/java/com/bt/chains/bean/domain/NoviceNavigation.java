package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;

@ApiObject(name = "NoviceNavigation", description = "新手导航")
public class NoviceNavigation {
	private int userId;
	private int navigationId;
	private String createDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNavigationId() {
		return navigationId;
	}
	public void setNavigationId(int navigationId) {
		this.navigationId = navigationId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
