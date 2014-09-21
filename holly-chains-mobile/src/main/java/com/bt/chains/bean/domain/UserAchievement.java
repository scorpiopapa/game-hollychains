package com.bt.chains.bean.domain;

import java.util.Date;


import com.bt.chains.bean.Product;

public class UserAchievement extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2152453197287890600L;

	private int id;
	
	private int userId;
	
	private int rewardId;
	
	private int type;
	
	private String status;
	
	private Date createDate;

	private Date updateDate;
	
	private String name;
	
	private String description;
	
	private String category;
	
	private int money;
	
	private int specialMoney;
	
	private int weapon;
	
	private String weaponName;
	
	private int weaponCount;
	
	private String others;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRewardId() {
		return rewardId;
	}

	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	
}
