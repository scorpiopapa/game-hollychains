/**
 * 
 */
package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.joinway.bean.domain.DomainEntity;


/**
 * @author neu
 *
 */
@ApiObject(name = "WeaponConfigView", description = "扭蛋获得的武器信息")
public class WeaponConfigView extends DomainEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1137409333483505745L;
	/**
	 * 武器ID
	 */
	@ApiObjectField(description = "武器ID")
	private int weaponId;
	/**
	 * 武器权重
	 */
	@ApiObjectField(description = "武器权重")
	private int weight;
	public int getWeaponId() {
		return weaponId;
	}
	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String getTableName() {
		return "GASHA_CONFIG";
	}
	@Override
	public String getIdName() {
		return "WEAPON_ID";
	}
}

