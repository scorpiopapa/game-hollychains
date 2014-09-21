package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "Item", description = "物品信息")
public class Item extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5086189118628229066L;

	@ApiObjectField(description = "物品id")
	int id;
	
	@ApiObjectField(description = "物品等级")
	int rank;

	public Item(){}
	
	public Item(int id, int rank) {
		this.id = id;
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
