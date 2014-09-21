package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.joinway.bean.view.View;

@ApiObject(name = "NoviceNavigationView", description = "当前需要的导航")
public class NoviceNavigationView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1355994067166312720L;
	
	@ApiObjectField(description = "下一步导航ID，如果为0，说明导航都已完成")
	private int navigationId;

	public int getNavigationId() {
		return navigationId;
	}
	public void setNavigationId(int navigationId) {
		this.navigationId = navigationId;
	}
}
