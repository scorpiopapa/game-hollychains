package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@Deprecated
@ApiObject(name = "UserMagicView", description = "用户所有的魔法", show=false)
public class UserMagicView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3818038337080019154L;

	@ApiObjectField(description = "用户魔法列表")
	List<Item> magics;

	public List<Item> getMagics() {
		return magics;
	}

	public void setMagics(List<Item> magics) {
		this.magics = magics;
	}
	
}
