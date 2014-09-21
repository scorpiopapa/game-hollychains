package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Prop;

@ApiObject(name = "PropListView", description = "购买列表")
public class PropListView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2800419327834510661L;


	
	@ApiObjectField(description = "道具信息")
	private List<Prop> propList;

	public List<Prop> getPropList() {
		return propList;
	}
	public void setPropList(List<Prop> propList) {
		this.propList = propList;
	}
}
