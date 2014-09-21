package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "MoneyView", description = "返回用户金币和付费币信息")
public class MoneyView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6127499567417916543L;
	
	@ApiObjectField(description = "用户金币")
	private int money;
	@ApiObjectField(description = "用户付费币")
	private int specialMoney;
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
