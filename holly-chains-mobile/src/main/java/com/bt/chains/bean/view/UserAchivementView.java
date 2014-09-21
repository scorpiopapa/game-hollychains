package com.bt.chains.bean.view;

import java.util.Date;

import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
@ApiObject(name = "UserAchivementView", description = "用户成就信息")
public class UserAchivementView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -134816639419973159L;

	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "奖励ID")
	private int id;
	
	@ApiObjectField(description = "奖励ID")
	private int rewardId;
	
	@ApiObjectField(description = "成就类型")
	private int type;
	
	@ApiObjectField(description = "成就状态")
	private String status;
	
	@ApiObjectField(description = "成就名称")
	private String name;
	
	@ApiObjectField(description = "成就描述")
	private String description;
	
	@ApiObjectField(description = "成就类别")
	private String category;
	
	@ApiObjectField(description = "金币")
	private int money;
	
	@ApiObjectField(description = "宝石")
	private int specialMoney;
	
	@ApiObjectField(description = "武器id")
	private int weapon;
	
	@ApiObjectField(description = "武器名称")
	private int weaponName;
	
	@ApiObjectField(description = "成就数量")
	private int weaponCount;
	
	@ApiObjectField(description = "其他")
	private String others;
	
	@ApiObjectField(description = "创建日期")
	private Date createDate;
	
	@ApiObjectField(description = "更新日期")
	private Date updateDate;
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(int weaponName) {
		this.weaponName = weaponName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
