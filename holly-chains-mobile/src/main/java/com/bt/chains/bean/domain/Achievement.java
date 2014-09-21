package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

/**
 * 奖励
 */
public class Achievement extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5359116474404063613L;
	/**
	 * 奖励
	 */
	private int aid;
	/**
	 * 
	 */
	private int value;
	/**
	 * 金币
	 */
	private int gold;
	/**
	 * 银币
	 */
	private int silver;
	/**
	 * 道具ID
	 */
	private int propId;
	/**
	 * 道具数量
	 */
	private int propCount;
	/**
	 * 强度
	 */
	private int strength;
	/**
	 * 武器ID
	 */
	private int weaponId;
	/**
	 * 武器数量
	 */
	private int weaponCount;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getSilver() {
		return silver;
	}
	public void setSilver(int silver) {
		this.silver = silver;
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
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
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
}
