package com.bt.chains.bean.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

/**
 * 炼狱模式 随机分配的3个职业与武器对象
 * 
 * @author javier
 * 
 */
@ApiObject(name = "UserHellAssignView", description = "炼狱模式关卡信息")
public class UserHellAssignView extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7979208902287367039L;
	@ApiObjectField(description = "炼狱用户随机职业列表")
	private List<Param> rolelist;
//	@ApiObjectField(description = "炼狱用户随机武器列表行1")
//	private List<String> weaponList;
	
	@ApiObjectField(description = "炼狱用户随机武器列表行1")
	private List<Param> weaponsFirstLine;
	
	@ApiObjectField(description = "炼狱用户随机武器列表行2")
	private List<Param> weaponsSecondLine;
	
	@ApiObjectField(description = "炼狱用户随机武器列表行3")
	private List<Param> weaponsThridLine;
	

	@ApiObjectField(description = "炼狱用户随机魔法列表")
	private List<Param> magicList;
	
	public List<Param> getMagicList() {
		return magicList;
	}

	public void setMagicList(List<Param> magicList) {
		this.magicList = magicList;
	}

	public List<Param> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<Param> rolelist) {
		this.rolelist = rolelist;
	}

	public List<Param> getWeaponsFirstLine() {
		return weaponsFirstLine;
	}

	public void setWeaponsFirstLine(List<Param> weaponsFirstLine) {
		this.weaponsFirstLine = weaponsFirstLine;
	}

	public List<Param> getWeaponsSecondLine() {
		return weaponsSecondLine;
	}

	public void setWeaponsSecondLine(List<Param> weaponsSecondLine) {
		this.weaponsSecondLine = weaponsSecondLine;
	}

	public List<Param> getWeaponsThridLine() {
		return weaponsThridLine;
	}

	public void setWeaponsThridLine(List<Param> weaponsThridLine) {
		this.weaponsThridLine = weaponsThridLine;
	}

//	public List<String> getWeaponList() {
//		return weaponList;
//	}
//
//	public void setWeaponList(List<String> weaponList) {
//		this.weaponList = weaponList;
//	}

}
