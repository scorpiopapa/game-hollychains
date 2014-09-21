package com.bt.chains.bean.domain;

import java.util.Date;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

public class Notice extends Product{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1755985180548498772L;
	/**
	 * 通知ID
	 */
	private int noticeId;
	/**
	 * 通知内容
	 */
	private String noticeContent;
	/**
	 * 创建时间
	 */
	private Date createTime;
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
