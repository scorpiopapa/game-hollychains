package com.bt.chains.bean.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "EnterCheckpointForm", description = "进入关卡")
public class EnterCheckpointForm extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8834147870186915385L;
	
	@ApiObjectField(description = "用户id")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "消耗的体力数")
	@Min(0)
	private int power;
	
	@ApiObjectField(description = "关卡ID")
	@Min(1)
	private int sceneId;
	
	@ApiObjectField(description = "关卡类型，0-普通关卡；1-精英关卡；2-英雄关卡；3-活动关卡；")
	@Min(0)
	@Max(3)
	private int sceneType;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public int getSceneType() {
		return sceneType;
	}

	public void setSceneType(int sceneType) {
		this.sceneType = sceneType;
	}
}
