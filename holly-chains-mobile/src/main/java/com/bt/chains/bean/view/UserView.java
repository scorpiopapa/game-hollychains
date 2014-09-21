package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.User;

@ApiObject(name = "UserView", description = "返回用户信息")
public class UserView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1113143294493661590L;
	
	@ApiObjectField(description = "用户信息")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
