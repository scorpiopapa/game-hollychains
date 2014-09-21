package com.bt.chains.bean.domain;

import com.bt.chains.bean.Product;

public class UserFinishedCheckpoint extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7491127446361773215L;
	
	/**
	 * ID
	 */
	private int id;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 关卡ID
	 */
	private int checkpointId;
	/**
	 * 大关卡
	 */
	private String bigStage;
	/**
	 * 小关卡
	 */
	private String smallStage;
	/**
	 * 体力值
	 */
	private int power;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCheckpointId() {
		return checkpointId;
	}
	public void setCheckpointId(int checkpointId) {
		this.checkpointId = checkpointId;
	}
	public String getBigStage() {
		return bigStage;
	}
	public void setBigStage(String bigStage) {
		this.bigStage = bigStage;
	}
	public String getSmallStage() {
		return smallStage;
	}
	public void setSmallStage(String smallStage) {
		this.smallStage = smallStage;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}
