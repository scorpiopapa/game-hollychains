package com.bt.chains.bean.form;

import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "CheckpointsForm", description = "包含完成关卡后需要更新到服务器的信息")
public class CheckpointsForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7990550785261865722L;
	
	@ApiObjectField(description = "关卡ID")
	@Min(1)
	private int sceneId;

	@ApiObjectField(description = "用户ID")
	@Min(1)
	int userId;
	
	@ApiObjectField(description = "用户获得的金币")
	@Min(0)
	int money;
	
//	@ApiObjectField(description = "炼狱模式中获得的分数")
//	@Min(0)
//	int score;
	
//	@ApiObjectField(description = "炼狱模式中使用的职业id")
//	@Min(1)
//	int roleId;

//	@ApiObjectField(description = "无限关卡类型:0-随机无限模式;1-自定义无限模式")
//	@Min(0) @Max(1)
//	int type;
	
	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

//	public int getScore() {
//		return score;
//	}
//
//	public void setScore(int score) {
//		this.score = score;
//	}
//
//	public int getType() {
//		return type;
//	}
//
//	public void setType(int type) {
//		this.type = type;
//	}
//
//	public int getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}
}
