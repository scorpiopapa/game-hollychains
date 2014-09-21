package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "WeaponStatus", description = "用户奖励获得的武器状态")
public class RewardWeaponStatus extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1208426322939008232L;

	@ApiObjectField(description = "解锁的武器wid")
	int wid;
	
	@ApiObjectField(description = "解锁的武器id")
	int weaponId;
	
	@ApiObjectField(description = "true-新武器，false-非新武器")
	boolean newWeapon;
	
	@ApiObjectField(description = "true-由于仓库已满，未获得该武器，false-仓库未满，获得了此武器")
	boolean dropped;

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public boolean isNewWeapon() {
		return newWeapon;
	}

	public void setNewWeapon(boolean newWeapon) {
		this.newWeapon = newWeapon;
	}

	public boolean isDropped() {
		return dropped;
	}

	public void setDropped(boolean dropped) {
		this.dropped = dropped;
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}
	
}
