package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

/**
 * 用户职业配置信息
 */
public class RoleConfig extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7297245886142209807L;
	
	/**
	 * 职业ID
	 */
	private int jobId;
	/**
	 * 解锁关卡
	 */
	private int unlockCheckpoints;
	/**
	 * 解锁金币
	 */
	private int unlockGold;
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getUnlockCheckpoints() {
		return unlockCheckpoints;
	}
	public void setUnlockCheckpoints(int unlockCheckpoints) {
		this.unlockCheckpoints = unlockCheckpoints;
	}
	public int getUnlockGold() {
		return unlockGold;
	}
	public void setUnlockGold(int unlockGold) {
		this.unlockGold = unlockGold;
	}
}
