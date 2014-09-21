package com.bt.chains.bean.domain;

import java.util.Date;
import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "User", description = "用户")
public class User extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2627587028687253960L;
	/**
	 * 用户ID
	 */
	@ApiObjectField(description = "用户ID")
	private int userId;
	/**
	 * 用户名称
	 */
	@ApiObjectField(description = "用户名称")
	private String name;
	/**
	 * 用户状态
	 */
	@ApiObjectField(description = "用户状态，默认为Y:活跃用户,N:冻结用户")
	private String status;
	/**
	 * 银币
	 */
	@ApiObjectField(description = "银币")
	private int money;
	/**
	 * 金币
	 */
	@ApiObjectField(description = "金币")
	private int specialMoney;
	/**
	 * 体力
	 */
	private int power;
	/**
	 * 市场ID
	 */
	@ApiObjectField(description = "市场ID")
	private String marketId;
	/**
	 * 市场：A：苹果；G：谷歌
	 */
	@ApiObjectField(description = "市场：A：苹果；G：谷歌")
	private String market;
	
	@ApiObjectField(description = "绑定到的用户id")
	int bindUserId;
	
	/**
	 * 最后连接时间
	 */
	@ApiObjectField(description = "最后连接时间")
	private Date lastConnectedTime;
	/**
	 * 注册时间
	 */
	@ApiObjectField(description = "注册时间")
	private Date registerTime;
	/**
	 * 登录时间
	 */
	@ApiObjectField(description = "登录时间")
	private Date loginTime;
	
	/**
	 * 用户持有的武器IDS
	 * @return
	 */
	private List<Integer> weaponIds;
	
	/**
	 * 用户持有的武器IDS
	 * @return
	 */
	private List<Integer> magicIds;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Date getLastConnectedTime() {
		return lastConnectedTime;
	}
	public void setLastConnectedTime(Date lastConnectedTime) {
		this.lastConnectedTime = lastConnectedTime;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public List<Integer> getWeaponIds() {
		return weaponIds;
	}
	public void setWeaponIds(List<Integer> weaponIds) {
		this.weaponIds = weaponIds;
	}
	public List<Integer> getMagicIds() {
		return magicIds;
	}
	public void setMagicIds(List<Integer> magicIds) {
		this.magicIds = magicIds;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getMarketId() {
		return marketId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public int getBindUserId() {
		return bindUserId;
	}
	public void setBindUserId(int bindUserId) {
		this.bindUserId = bindUserId;
	}
}
