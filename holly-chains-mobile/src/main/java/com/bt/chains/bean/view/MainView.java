package com.bt.chains.bean.view;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.BaseData;
import com.bt.chains.bean.domain.Identity;
import com.bt.chains.bean.domain.LastItem;
import com.bt.chains.bean.domain.Prop;
import com.bt.chains.bean.domain.UserRole;

@ApiObject(name = "MainView", description = "登录用户返回信息")
public class MainView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1529671472689278955L;
	
	@ApiObjectField(description = "用户id")
	private int userId;
	
	@ApiObjectField(description = "用户市场id")
	String marketId;
	
	@ApiObjectField(description = "用户名")
	private String name = "player";
	
	@ApiObjectField(description = "用户银币")
	private int money;
	
	@ApiObjectField(description = "用户金币")
	private int specialMoney;
	
	@ApiObjectField(description = "用户职业")
	private List<UserRole> jobList;
	
	@ApiObjectField(description = "基本属性值")
	private List<BaseData> baseDatas;
	
	//@ApiObjectField(description = "用户武器")
	//private List<UserWeapon> weaponList;
	
//	@ApiObjectField(description = "用户魔法")
//	private List<UserMagic> magicList;
	
	@ApiObjectField(description = "用户最后一次使用的职业id")
	private int lastRoleId;
	
	@ApiObjectField(description = "用户最后一次使用的武器列表")
	private List<LastItem> lastUserWeaponList;
	
	@ApiObjectField(description = "用户最后一次使用的魔法列表")
	private List<LastItem> lastUserMagicList;

	@ApiObjectField(description = "用户可领取的成就个数")
	private int achievementCount;
	
	@ApiObjectField(description = "应用商店中的商品id")
	List<Identity> productIds;
	
	@ApiObjectField(description = "武器制造券个数")
	private int weaponTicketCount;
	
	@ApiObjectField(description = "炼狱模式参加券个数")
	private int unlimitedTicketCount;
	
	@ApiObjectField(description = "购买道具菜单")
	private List<Prop> prop;
	
	@ApiObjectField(description = "购买武器菜单")
	private List<ShopWeaponMenu> shopWeaponMenu;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserRole> getJobList() {
		return jobList;
	}

	public void setJobList(List<UserRole> jobList) {
		this.jobList = jobList;
	}
//
//	public List<UserWeapon> getWeaponList() {
//		return weaponList;
//	}
//
//	public void setWeaponList(List<UserWeapon> weaponList) {
//		this.weaponList = weaponList;
//	}

//	public List<UserMagic> getMagicList() {
//		return magicList;
//	}
//
//	public void setMagicList(List<UserMagic> magicList) {
//		this.magicList = magicList;
//	}

	public int getMoney() {
		return money;
	}

	public List<LastItem> getLastUserWeaponList() {
		return lastUserWeaponList;
	}

	public void setLastUserWeaponList(List<LastItem> lastUserWeaponList) {
		this.lastUserWeaponList = lastUserWeaponList;
	}

	public List<LastItem> getLastUserMagicList() {
		return lastUserMagicList;
	}

	public void setLastUserMagicList(List<LastItem> lastUserMagicList) {
		this.lastUserMagicList = lastUserMagicList;
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

	public int getAchievementCount() {
		return achievementCount;
	}

	public void setAchievementCount(int achievementCount) {
		this.achievementCount = achievementCount;
	}

	public int getLastRoleId() {
		return lastRoleId;
	}

	public void setLastRoleId(int lastRoleId) {
		this.lastRoleId = lastRoleId;
	}

	public List<Identity> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Identity> productIds) {
		this.productIds = productIds;
	}

	public int getWeaponTicketCount() {
		return weaponTicketCount;
	}

	public void setWeaponTicketCount(int weaponTicketCount) {
		this.weaponTicketCount = weaponTicketCount;
	}

	public int getUnlimitedTicketCount() {
		return unlimitedTicketCount;
	}

	public void setUnlimitedTicketCount(int unlimitedTicketCount) {
		this.unlimitedTicketCount = unlimitedTicketCount;
	}

	public List<Prop> getProp() {
		return prop;
	}

	public void setProp(List<Prop> prop) {
		this.prop = prop;
	}

	public List<ShopWeaponMenu> getShopWeaponMenu() {
		return shopWeaponMenu;
	}

	public void setShopWeaponMenu(List<ShopWeaponMenu> shopWeaponMenu) {
		this.shopWeaponMenu = shopWeaponMenu;
	}

	public List<BaseData> getBaseDatas() {
		return baseDatas;
	}

	public void setBaseDatas(List<BaseData> baseDatas) {
		this.baseDatas = baseDatas;
	}

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
}
