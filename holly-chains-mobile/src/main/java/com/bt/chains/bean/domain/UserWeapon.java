package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "UserWeapon", description = "用户武器")
public class UserWeapon extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6748835802340934230L;
	
	@ApiObjectField(description = "ID，主键")
	private int id;
	/**
	 * 用户ID
	 */
	@ApiObjectField(description = "用户ID")
	private int userId;
	/**
	 * 武器WID
	 */
	@ApiObjectField(description = "武器WID")
	private int wId;
	/**
	 * 武器ID
	 */
	@ApiObjectField(description = "武器ID")
	private int weaponId;
	/**
	 * 武器等级
	 */
	@ApiObjectField(description = "武器级别")
	private int weaponRank;
	/**
	 * 武器是否在背包中
	 */
	@ApiObjectField(description = "武器背包，0-未在背包中；1-在背包中")
	private int bagStatus;
	
	@ApiObjectField(description = "武器当前经验值")
	int point;
	
	@ApiObjectField(description = "0-非当前武器;1-当前武器")
	int inUse;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getWeaponId() {
		return weaponId;
	}
	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}
	public int getWeaponRank() {
		return weaponRank;
	}
	public void setWeaponRank(int weaponRank) {
		this.weaponRank = weaponRank;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBagStatus() {
		return bagStatus;
	}
	public void setBagStatus(int bagStatus) {
		this.bagStatus = bagStatus;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getInUse() {
		return inUse;
	}
	public void setInUse(int inUse) {
		this.inUse = inUse;
	}
	public int getwId() {
		return wId;
	}
	public void setwId(int wId) {
		this.wId = wId;
	}
}
