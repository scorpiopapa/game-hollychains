package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.joinway.bean.view.View;

@ApiObject(name = "BindResult", description = "设备迁移结果")
public class BindResult extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5057855735466934850L;
	
	@ApiObjectField(description = "用户id")
	int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
