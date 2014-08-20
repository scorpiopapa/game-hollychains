package com.bt.chains.bean.domain;

import com.joinway.bean.domain.DomainEntity;
import com.joinway.bean.domain.annotation.DomainField;
import com.joinway.bean.domain.converter.IntToStringConverter;

public class Weapon extends DomainEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6748835802340934230L;
	/**
	 * 武器ID
	 */
	private int weaponId;
	/**
	 * 武器名称
	 */
	private String weaponName;
	
	/**
	 * 武器名称
	 */
	@DomainField(converter=IntToStringConverter.class)
	private String wid;
	
	
	/**
	 * 基础经验值
	 */
	private int baseExperience;
	
	/**
	 * 卖出价格
	 */
	private int sellPrice;
	/**
	 * 最大血量
	 */
	private int maxBlood;
	/**
	 * 每升一级血量增加量
	 */
	private int minBlood;
	/**
	 * 血瓶最大回复值
	 */
	private int maxBloodReply;
	/**
	 * 每升一级血瓶增加量
	 */
	private int minBloodReply;
	/**
	 * 基础攻击力
	 */
	private int maxBaseAttack;
	/**
	 * 每升一级基础攻击力增加量
	 */
	private int minBaseAttack;
	/**
	 * 武器攻击力
	 */
	private int maxAttack;
	/**
	 * 每升一级武器攻击力增加量
	 */
	private int minAttack;
	/**
	 * 盾的最大值
	 */
	private int maxShield;
	/**
	 * 每升一级盾的增加量
	 */
	private int minShield;
	/**
	 * 盾的防御力
	 */
	private int maxDefenseShield;
	/**
	 * 每升一级盾防御力的增加量
	 */
	private int minDefenseShield;
	/**
	 * 吸血值
	 */
	private float maxVampire;
	/**
	 * 每升一级吸血值的增加量
	 */
	private float minVampire;
	
	/**
	 * 暴击率
	 */
	private float maxCritRate;
	/**
	 * 每升一级暴击率的增加量
	 */
	private float minCritRate;
	
	/**
	 *穿透率
	 */
	private float maxPenetrationRate;
	/**
	 * 每升一级穿透率的增加量
	 */
	private float minPenetrationRate;
	
	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public void setWid(int wid) {
		this.wid = String.valueOf(wid);
	}
	
	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public int getBaseExperience() {
		return baseExperience;
	}

	public void setBaseExperience(int baseExperience) {
		this.baseExperience = baseExperience;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getMaxBlood() {
		return maxBlood;
	}

	public void setMaxBlood(int maxBlood) {
		this.maxBlood = maxBlood;
	}

	public int getMinBlood() {
		return minBlood;
	}

	public void setMinBlood(int minBlood) {
		this.minBlood = minBlood;
	}

	public int getMaxBloodReply() {
		return maxBloodReply;
	}

	public void setMaxBloodReply(int maxBloodReply) {
		this.maxBloodReply = maxBloodReply;
	}

	public int getMinBloodReply() {
		return minBloodReply;
	}

	public void setMinBloodReply(int minBloodReply) {
		this.minBloodReply = minBloodReply;
	}

	public int getMaxBaseAttack() {
		return maxBaseAttack;
	}

	public void setMaxBaseAttack(int maxBaseAttack) {
		this.maxBaseAttack = maxBaseAttack;
	}

	public int getMinBaseAttack() {
		return minBaseAttack;
	}

	public void setMinBaseAttack(int minBaseAttack) {
		this.minBaseAttack = minBaseAttack;
	}

	public int getMaxAttack() {
		return maxAttack;
	}

	public void setMaxAttack(int maxAttack) {
		this.maxAttack = maxAttack;
	}

	public int getMinAttack() {
		return minAttack;
	}

	public void setMinAttack(int minAttack) {
		this.minAttack = minAttack;
	}

	public int getMaxShield() {
		return maxShield;
	}

	public void setMaxShield(int maxShield) {
		this.maxShield = maxShield;
	}

	public int getMinShield() {
		return minShield;
	}

	public void setMinShield(int minShield) {
		this.minShield = minShield;
	}

	public int getMaxDefenseShield() {
		return maxDefenseShield;
	}

	public void setMaxDefenseShield(int maxDefenseShield) {
		this.maxDefenseShield = maxDefenseShield;
	}

	public int getMinDefenseShield() {
		return minDefenseShield;
	}

	public void setMinDefenseShield(int minDefenseShield) {
		this.minDefenseShield = minDefenseShield;
	}

	public float getMaxVampire() {
		return maxVampire;
	}

	public void setMaxVampire(float maxVampire) {
		this.maxVampire = maxVampire;
	}

	public float getMinVampire() {
		return minVampire;
	}

	public void setMinVampire(float minVampire) {
		this.minVampire = minVampire;
	}

	public float getMaxCritRate() {
		return maxCritRate;
	}

	public void setMaxCritRate(float maxCritRate) {
		this.maxCritRate = maxCritRate;
	}

	public float getMinCritRate() {
		return minCritRate;
	}

	public void setMinCritRate(float minCritRate) {
		this.minCritRate = minCritRate;
	}

	public float getMaxPenetrationRate() {
		return maxPenetrationRate;
	}

	public void setMaxPenetrationRate(float maxPenetrationRate) {
		this.maxPenetrationRate = maxPenetrationRate;
	}

	public float getMinPenetrationRate() {
		return minPenetrationRate;
	}

	public void setMinPenetrationRate(float minPenetrationRate) {
		this.minPenetrationRate = minPenetrationRate;
	}

	@Override
	public String getIdName() {
		return "WID";
	}

	@Override
	public int getId() {
		return Integer.valueOf(wid);
	}

	@Override
	public void setId(int id) {
		wid = String.valueOf(id);
	}
}
