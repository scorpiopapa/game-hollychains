package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "RankingView", description = "排行榜信息")
public class RankingView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1638439824838064895L;

	@ApiObjectField(description = "排名序号")
	int order;
	
	@ApiObjectField(description = "玩家名字")
	String name;
	
	@ApiObjectField(description = "职业id")
	int roleId;
	
	@ApiObjectField(description = "分数")
	int score;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
