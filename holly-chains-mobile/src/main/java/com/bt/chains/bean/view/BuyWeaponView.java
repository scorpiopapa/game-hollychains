package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.GashaWeapon;
import com.bt.chains.bean.domain.Param;

@ApiObject(name = "BuyWeaponView", description = "购买武器返回值")
public class BuyWeaponView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6197941390006044146L;
	
	@ApiObjectField(description = "购买武器返回的武器WIDs")
	private List<GashaWeapon> gashaWeapons;
	@ApiObjectField(description = "金币")
	private int money;
	@ApiObjectField(description = "宝石")
	private int specialMoney;
	
	
	public List<GashaWeapon> getGashaWeapons() {
		return gashaWeapons;
	}
	public void setGashaWeapons(List<GashaWeapon> gashaWeapons) {
		this.gashaWeapons = gashaWeapons;
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
}
