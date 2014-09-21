package com.bt.chains.bean.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "WeaponComposeForm", description = "武器合成")
public class WeaponComposeForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -689122792529336250L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
//	@ApiObjectField(description = "贡品武器IDS")
//	@NotNull
//	private List<Param> tributeIds;
	
	@ApiObjectField(description = "要升级的武器唯一标识符(主键ID)")
	@Min(1)
	//private int weaponId;
	private int id;
	
//	@ApiObjectField(description = "武器级别")
//	@Min(1)
//	private int weaponRank;

	@ApiObjectField(description = "贡品唯一标识符(主键ID)")
	@NotEmpty
	private List<SacrifiedWeapon> sacrifiedWeapons;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

//	public int getWeaponId() {
//		return weaponId;
//	}
//
//	public void setWeaponId(int weaponId) {
//		this.weaponId = weaponId;
//	}

//	public int getWeaponRank() {
//		return weaponRank;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public void setWeaponRank(int weaponRank) {
//		this.weaponRank = weaponRank;
//	}
//
//	public List<Param> getTributeIds() {
//		return tributeIds;
//	}
//
//	public void setTributeIds(List<Param> tributeIds) {
//		this.tributeIds = tributeIds;
//	}

	public List<SacrifiedWeapon> getSacrifiedWeapons() {
		return sacrifiedWeapons;
	}

	public void setSacrifiedWeapons(List<SacrifiedWeapon> sacrifiedWeapons) {
		this.sacrifiedWeapons = sacrifiedWeapons;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
