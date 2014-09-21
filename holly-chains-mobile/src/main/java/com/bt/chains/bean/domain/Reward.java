package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class Reward extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4892925946732848602L;
	/**
	 * 奖励ID
	 */
	private String rewardId;
	/**
	 * 奖励排序
	 */
	private String rewardOrder;
	/**
	 * 奖励名称
	 */
	private String rewardName;
	/**
	 * 奖励内容
	 */
	private String rewardContext;
	
	public String getRewardId() {
		return rewardId;
	}
	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
	}
	public String getRewardOrder() {
		return rewardOrder;
	}
	public void setRewardOrder(String rewardOrder) {
		this.rewardOrder = rewardOrder;
	}
	public String getRewardName() {
		return rewardName;
	}
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}
	public String getRewardContext() {
		return rewardContext;
	}
	public void setRewardContext(String rewardContext) {
		this.rewardContext = rewardContext;
	}
}
