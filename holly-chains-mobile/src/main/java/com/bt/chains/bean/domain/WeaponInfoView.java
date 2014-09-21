package com.bt.chains.bean.domain;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "WeaponInfoView", description = "武器相关信息：仓库，背包容量，用户关联武器")
public class WeaponInfoView extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4592602726437869655L;

	@ApiObjectField(description = "背包容量")
	private int backPackCapacity;

	@ApiObjectField(description = "武器仓库容量")
	private int weaponStoreCapacity;

	@ApiObjectField(description = "用户武器列表")
	private List<UserWeapon> userWeaponInfoList;

	public int getBackPackCapacity() {
		return backPackCapacity;
	}

	public void setBackPackCapacity(int backPackCapacity) {
		this.backPackCapacity = backPackCapacity;
	}

	public int getWeaponStoreCapacity() {
		return weaponStoreCapacity;
	}

	public void setWeaponStoreCapacity(int weaponStoreCapacity) {
		this.weaponStoreCapacity = weaponStoreCapacity;
	}

	public List<UserWeapon> getUserWeaponInfoList() {
		return userWeaponInfoList;
	}

	public void setUserWeaponInfoList(List<UserWeapon> userWeaponInfoList) {
		this.userWeaponInfoList = userWeaponInfoList;
	}

}
