package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "UpdateItemView", description = "更新武器，魔法结果")
public class UpdateItemView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 460234572995214222L;

	@ApiObjectField(description = "更新后的武器或魔法")
	List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
