package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class RewardConfig extends Product {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1417249364427567038L;
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 奖励类别
	 */
	private String category;
	/**
	 * 奖励银币
	 */
	private int money;
	/**
	 * 奖励金币
	 */
	private int specialMoney;
	/**
	 * 奖励武器id
	 */
	private int weapon;
	/**
	 * 奖励武器名称
	 */
	private String weaponName;
	/**
	 * 奖励武器或道具数量
	 */
	private int weaponCount;
	/**
	 * 其他奖励
	 */
	private String others;
	/**
	 * 奖励类型
	 */
	private int rewardType;
	/**
	 * 奖励道具id
	 */
	private int prop;
	/**
	 * 奖励道具名称
	 */
	private String propName;
	/**
	 * 奖励道具个数
	 */
	private int propCount;
	
	public String getWeaponName() {
		return weaponName;
	}
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	public String getPropName() {
		return propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
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
	public int getWeapon() {
		return weapon;
	}
	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}
	public int getWeaponCount() {
		return weaponCount;
	}
	public void setWeaponCount(int weaponCount) {
		this.weaponCount = weaponCount;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public int getRewardType() {
		return rewardType;
	}
	public void setRewardType(int rewardType) {
		this.rewardType = rewardType;
	}
	public int getProp() {
		return prop;
	}
	public void setProp(int prop) {
		this.prop = prop;
	}
	public int getPropCount() {
		return propCount;
	}
	public void setPropCount(int propCount) {
		this.propCount = propCount;
	}
}
