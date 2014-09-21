package com.bt.chains.bean.domain;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "PlaySmallStageInfoView", description = "小关卡信息")
public class PlaySmallStageInfoView extends Product{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7508512708117787973L;

	@ApiObjectField(description = "小关卡id")
	private int stage2Id;
	
	@ApiObjectField(description = "小关卡名称")
	private String stage2Name = "";
	
	@ApiObjectField(description = "是否已通关标志  0：已通关   1：未通关")
	private int palyedFlag = 1;

	@ApiObjectField(description = "体力值")
	private int stamina = 0;

	public int getPalyedFlag() {
		return palyedFlag;
	}

	public void setPalyedFlag(int palyedFlag) {
		this.palyedFlag = palyedFlag;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getStage2Id() {
		return stage2Id;
	}

	public void setStage2Id(int stage2Id) {
		this.stage2Id = stage2Id;
	}


	public String getStage2Name() {
		return stage2Name;
	}

	public void setStage2Name(String stage2Name) {
		this.stage2Name = stage2Name;
	}
	
	
}
