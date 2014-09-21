package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.domain.BaseData;
import com.joinway.bean.view.View;

@ApiObject(name = "BaseDataView", description = "获取基础数据")
public class BaseDataView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6424605419978716898L;
	
	@ApiObjectField(description = "基础数据信息")
	private List<BaseData> baseDatas;

	public List<BaseData> getBaseDatas() {
		return baseDatas;
	}

	public void setBaseDatas(List<BaseData> baseDatas) {
		this.baseDatas = baseDatas;
	}
}
