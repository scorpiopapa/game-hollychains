package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "ShopWeaponMenu", description = "购买武器菜单列表")
public class ShopWeaponMenu extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2686061893847125232L;

	@ApiObjectField(description = "武器扭蛋条目唯一标示 同步于csv-gashaid")
	int gashaId;

	@ApiObjectField(description = "条目名称 同步于 csv-name")
	String textName;

	@ApiObjectField(description = "条目名称 同步于 csv-disc")
	String textDesc;

	@ApiObjectField(description = "可获得的金币数量 同步于 csv-coin")
	int gainMoneyCount;

	@ApiObjectField(description = "可获得的武器数量 同步于 csv-weapon")
	int gainWeaponCount;

	@ApiObjectField(description = "需花费的钻石数量 同步于 csv-price")
	int specialMoney;

	@ApiObjectField(description = "是否需要扭蛋券 同步于 csv-ticket 0不使用 1 使用")
	int ticket;

	public int getGashaId() {
		return gashaId;
	}

	public void setGashaId(int gashaId) {
		this.gashaId = gashaId;
	}

	public String getTextName() {
		return textName;
	}

	public void setTextName(String textName) {
		this.textName = textName;
	}

	public String getTextDesc() {
		return textDesc;
	}

	public void setTextDesc(String textDesc) {
		this.textDesc = textDesc;
	}

	public int getGainMoneyCount() {
		return gainMoneyCount;
	}

	public void setGainMoneyCount(int gainMoneyCount) {
		this.gainMoneyCount = gainMoneyCount;
	}

	public int getGainWeaponCount() {
		return gainWeaponCount;
	}

	public void setGainWeaponCount(int gainWeaponCount) {
		this.gainWeaponCount = gainWeaponCount;
	}

	public int getSpecialMoney() {
		return specialMoney;
	}

	public void setSpecialMoney(int specialMoney) {
		this.specialMoney = specialMoney;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

}
