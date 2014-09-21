package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "UnLimitedConfig", description = "无限模式配置数据")
public class UnLimitedConfig extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9104759845439123425L;
	
	@ApiObjectField(description = "无限模式id")
	private int id;
	
	@ApiObjectField(description = "名称")
	private String name;
	
	@ApiObjectField(description = "付费币")
	private int specialMoney;
	
	@ApiObjectField(description = "无限券数量")
	private int unlimitedSecuritiesNum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpecialMoney() {
		return specialMoney;
	}

	public void setSpecialMoney(int specialMoney) {
		this.specialMoney = specialMoney;
	}

	public int getUnlimitedSecuritiesNum() {
		return unlimitedSecuritiesNum;
	}

	public void setUnlimitedSecuritiesNum(int unlimitedSecuritiesNum) {
		this.unlimitedSecuritiesNum = unlimitedSecuritiesNum;
	}
}
