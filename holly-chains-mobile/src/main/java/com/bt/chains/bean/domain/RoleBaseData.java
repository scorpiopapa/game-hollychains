package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class RoleBaseData extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6263302935940156866L;
	/**
	 * 职业ID
	 */
	private int roleId;
	/**
	 * 职业级别
	 */
	private int roleRank;
	/**
	 * 盾
	 */
	private int shield;
	/**
	 * 盾防御
	 */
	private int shieldDefence;
	/**
	 * 血量回复
	 */
	private int healthPortion;
	/**
	 * 血量
	 */
	private int health;
	/**
	 * 基础攻击力
	 */
	private int basicDamage;
	/**
	 * 武器攻击力
	 */
	private int weaponDamage;
	/**
	 * 吸血值
	 */
	private float leech;
	/**
	 * 暴击率
	 */
	private float criticalDamage;
	/**
	 * 穿透率
	 */
	private float pierce;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getRoleRank() {
		return roleRank;
	}
	public void setRoleRank(int roleRank) {
		this.roleRank = roleRank;
	}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	public int getShieldDefence() {
		return shieldDefence;
	}
	public void setShieldDefence(int shieldDefence) {
		this.shieldDefence = shieldDefence;
	}
	public int getHealthPortion() {
		return healthPortion;
	}
	public void setHealthPortion(int healthPortion) {
		this.healthPortion = healthPortion;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getBasicDamage() {
		return basicDamage;
	}
	public void setBasicDamage(int basicDamage) {
		this.basicDamage = basicDamage;
	}
	public int getWeaponDamage() {
		return weaponDamage;
	}
	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}
	public float getLeech() {
		return leech;
	}
	public void setLeech(float leech) {
		this.leech = leech;
	}
	public float getCriticalDamage() {
		return criticalDamage;
	}
	public void setCriticalDamage(float criticalDamage) {
		this.criticalDamage = criticalDamage;
	}
	public float getPierce() {
		return pierce;
	}
	public void setPierce(float pierce) {
		this.pierce = pierce;
	}
}
