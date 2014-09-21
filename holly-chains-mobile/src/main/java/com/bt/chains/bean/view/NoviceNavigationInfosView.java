package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.domain.NoviceNavigation;
import com.joinway.bean.view.View;

@ApiObject(name = "NoviceNavigationInfosView", description = "用户导航数据历史")
public class NoviceNavigationInfosView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -98309406172035754L;
	
	@ApiObjectField(description = "用户所有导航数据")
	private List<NoviceNavigation> noviceNavigation;

	public List<NoviceNavigation> getNoviceNavigation() {
		return noviceNavigation;
	}

	public void setNoviceNavigation(List<NoviceNavigation> noviceNavigation) {
		this.noviceNavigation = noviceNavigation;
	}
}
