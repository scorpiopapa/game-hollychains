package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "NoticeMessage", description = "通知内容")
public class NoticeMessage extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3251556108318227959L;

	@ApiObjectField(description = "通知id")
	int id;
	
	@ApiObjectField(description = "通知文本")
	String message;

	public NoticeMessage(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
