package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserRole;

@Deprecated
@ApiObject(name = "IntensifyUserRoleView", description = "职业强化返回数据", show=false)
public class IntensifyUserRoleView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6689231329908845958L;
	
	@ApiObjectField(description = "用户")
	private User user;
	
	@ApiObjectField(description = "用户职业")
	private UserRole userRole;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
}
