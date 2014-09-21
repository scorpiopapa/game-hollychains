package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserWeapon;

@ApiObject(name = "IntensifyUserWeaponView", description = "武器强化返回数据")
public class IntensifyUserWeaponView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1215816686239472200L;
	
	@ApiObjectField(description = "用户")
	private User user;
	
	@ApiObjectField(description = "强化后的武器")
	private UserWeapon userWeapon;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserWeapon getUserWeapon() {
		return userWeapon;
	}

	public void setUserWeapon(UserWeapon userWeapon) {
		this.userWeapon = userWeapon;
	}
}
