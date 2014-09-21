package com.bt.chains.bean.domain;
import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "PlayStageInfoView", description = "大小关卡信息")
public class PlayStageInfoView extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4592602726437869655L;

	@ApiObjectField(description = "大关卡id")
	private int stage1Id;

	@ApiObjectField(description = "大关卡名称")
	private String stage1Name = "";

//	@ApiObjectField(description = "是否已通关标志  0：已通关   1：未通关")
//	private int palyedFlag;
//
//	@ApiObjectField(description = "体力值")
//	private int stamina;
	
	@ApiObjectField(description = "关卡类型，0：普通关卡；1：精英关卡；2：英雄关卡；3：无限关卡；4：活动关卡")
	private int sceneType;

	@ApiObjectField(description = "是否已通关标志  0：已通关   1：未通关")
	private int palyedFlag = 1;

//	@ApiObjectField(description = "体力值")
//	private int stamina;
	
	@ApiObjectField(description = "小关卡信息")
	private List<PlaySmallStageInfoView> playSmallStageInfoViewList;
	

	public List<PlaySmallStageInfoView> getPlaySmallStageInfoViewList() {
		return playSmallStageInfoViewList;
	}

	public void setPlaySmallStageInfoViewList(
			List<PlaySmallStageInfoView> playSmallStageInfoViewList) {
		this.playSmallStageInfoViewList = playSmallStageInfoViewList;
	}

//	public int getPalyedFlag() {
//		return palyedFlag;
//	}
//
//	public void setPalyedFlag(int palyedFlag) {
//		this.palyedFlag = palyedFlag;
//	}
//
//	public int getStamina() {
//		return stamina;
//	}
//
//	public void setStamina(int stamina) {
//		this.stamina = stamina;
//	}

	public int getSceneType() {
		return sceneType;
	}

	public void setSceneType(int sceneType) {
		this.sceneType = sceneType;
	}
//	public int getStamina() {
//		return stamina;
//	}
//
//	public void setStamina(int stamina) {
//		this.stamina = stamina;
//	}

	public int getStage1Id() {
		return stage1Id;
	}

	public void setStage1Id(int stage1Id) {
		this.stage1Id = stage1Id;
	}

	public String getStage1Name() {
		return stage1Name;
	}

	public void setStage1Name(String stage1Name) {
		this.stage1Name = stage1Name;
	}

	public int getPalyedFlag() {
		return palyedFlag;
	}

	public void setPalyedFlag(int palyedFlag) {
		this.palyedFlag = palyedFlag;
	}

}
