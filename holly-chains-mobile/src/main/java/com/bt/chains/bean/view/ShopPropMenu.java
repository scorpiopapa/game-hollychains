package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "ShopPropMenu", description = "购买道具菜单")
public class ShopPropMenu extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5780588142620714521L;

	@ApiObjectField(description = "菜单文本")
	String text;
	
	@ApiObjectField(description = "可获得的道具数量")
	int gainPropCount;
	
	@ApiObjectField(description = "花费的钻石数量")
	int specialMoney;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getGainPropCount() {
		return gainPropCount;
	}

	public void setGainPropCount(int gainPropCount) {
		this.gainPropCount = gainPropCount;
	}

	public int getSpecialMoney() {
		return specialMoney;
	}

	public void setSpecialMoney(int specialMoney) {
		this.specialMoney = specialMoney;
	}
}
