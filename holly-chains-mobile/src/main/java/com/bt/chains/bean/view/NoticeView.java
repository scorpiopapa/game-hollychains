package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "NoticeView", description = "查询通知信息")
public class NoticeView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2969884942075837479L;
	
	@ApiObjectField(description = "通知个数")
	private int count;
	
	@ApiObjectField(description = "通知信息列表")
	private String notices;

	public String getNotices() {
		return notices;
	}

	public void setNotices(String notices) {
		this.notices = notices;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
