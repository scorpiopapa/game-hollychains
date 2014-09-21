package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.joinway.bean.view.View;

@ApiObject(name = "BuyGemView", description = "购买宝石返回数据")
public class BuyGemView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2279583717117774035L;
	
	@ApiObjectField(description = "金币数量")
	private int money;
	@ApiObjectField(description = "宝石数量")
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
