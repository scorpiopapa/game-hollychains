package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "BaseData", description = "基础数据")
public class BaseData extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2941198249081811799L;
	
	@ApiObjectField(description = "基础数据ID：0:血量；1：血回复；2：基础攻击力；3：武器攻击力；4：盾最大值；5:盾的防御力；6：吸血值；7：暴击率；8：穿透率")
	private int id;
	@ApiObjectField(description = "基础数据值")
	private int data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}
