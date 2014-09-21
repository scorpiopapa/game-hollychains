package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class RankingRewardConfig extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8273547954429994423L;

	int percent;
	
	int money;
	
	int specialMoney;
	
	int weaponId;
	
	int weaponCount;
	
	int propId;
	
	int propCount;

	int propType;
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getSpecialMoney() {
		return specialMoney;
	}

	public void setSpecialMoney(int specialMoney) {
		this.specialMoney = specialMoney;
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	public int getWeaponCount() {
		return weaponCount;
	}

	public void setWeaponCount(int weaponCount) {
		this.weaponCount = weaponCount;
	}

	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public int getPropCount() {
		return propCount;
	}

	public void setPropCount(int propCount) {
		this.propCount = propCount;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public int getPropType() {
		return propType;
	}

	public void setPropType(int propType) {
		this.propType = propType;
	}
}
