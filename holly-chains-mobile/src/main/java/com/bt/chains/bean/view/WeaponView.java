package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.UserWeapon;

@ApiObject(name = "WeaponView", description = "武器（合成、导入、贩卖）返回信息")
public class WeaponView extends com.joinway.bean.view.View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8740414940092062511L;
	
	@ApiObjectField(description = "用户ID")
	private int userId;
	
	@ApiObjectField(description = "武器信息")
	private List<UserWeapon> weapons;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<UserWeapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<UserWeapon> weapons) {
		this.weapons = weapons;
	}
}
