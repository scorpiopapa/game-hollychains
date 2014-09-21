package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "RewardMaster", description = "奖励配置信息")
public class RewardMaster extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1350025733681204552L;
	@ApiObjectField(description = "奖励类型,1-每日登陆奖励（职业驱魔人）;2-累计登陆奖励（深造者）;"
			+ "3-普通关卡突破奖励（圣徒）;4-精英关卡突破奖励（精英）;5-英雄关卡突破奖励（英雄）;6-金币累计奖励（赏金猎人）;"
			+ "7-付费币累计奖励（挖金者）;8-天梯奖励（驱魔大师）")
	private int type;
	
	@ApiObjectField(description = "奖励名称")
	private String name;
	
	@ApiObjectField(description = "奖励内容")
	private String description;
	
	@ApiObjectField(description = "奖励排序")
	private  int rewardOrder;
	
	@ApiObjectField(description = "奖励进度")
	private  String rewardSchedule;
	
	@ApiObjectField(description = "奖励值类型, 1-金币， 2-宝石，3-武器， 4-道具，5-体力")
	private  int rewardValueType;

	@ApiObjectField(description = "奖励值")
	private  String rewardValue;
	
	@ApiObjectField(description = "奖励值数量（用于武器，道具奖励个数。 宝石，金币，体力为null）")
	private  String rewardValueCount;
	
	public int getRewardValueType() {
		return rewardValueType;
	}
	public void setRewardValueType(int rewardValueType) {
		this.rewardValueType = rewardValueType;
	}
	public String getRewardValue() {
		return rewardValue;
	}
	public void setRewardValue(String rewardValue) {
		this.rewardValue = rewardValue;
	}
	public String getRewardValueCount() {
		return rewardValueCount;
	}
	public void setRewardValueCount(String rewardValueCount) {
		this.rewardValueCount = rewardValueCount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRewardOrder() {
		return rewardOrder;
	}
	public void setRewardOrder(int rewardOrder) {
		this.rewardOrder = rewardOrder;
	}
	public String getRewardSchedule() {
		return rewardSchedule;
	}
	public void setRewardSchedule(String rewardSchedule) {
		this.rewardSchedule = rewardSchedule;
	}
	
}
