package com.bt.chains.bean.domain;

import java.util.Date;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "UserAchievementHistory", description = "奖励历史信息")
public class UserAchievementHistory extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2152453197287890600L;
	
	@ApiObjectField(description = "ID，主键")
	private int id;
	
	@ApiObjectField(description = "用户ID")
	private int userId;
	
	@ApiObjectField(description = "奖励ID")
	private int rewardId;
	
	@ApiObjectField(description = "奖励类型,1-每日登陆奖励（职业驱魔人）;2-累计登陆奖励（深造者）;"
			+ "3-普通关卡突破奖励（圣徒）;4-精英关卡突破奖励（精英）;5-英雄关卡突破奖励（英雄）;6-金币累计奖励（赏金猎人）;"
			+ "7-付费币累计奖励（挖金者）;8-天梯奖励（驱魔大师）")
	private int type;
	
	@ApiObjectField(description = "奖励完成状态，true-完成；false-未完成")
	private String compStatus;
	
	@ApiObjectField(description = "奖励领取状态，true-领取；false-未领取")
	private String status;
	
	@ApiObjectField(description = "奖励创建时间")
	private Date createDate;
	
	@ApiObjectField(description = "奖励修改时间")
	private Date updateDate;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRewardId() {
		return rewardId;
	}

	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompStatus() {
		return compStatus;
	}

	public void setCompStatus(String compStatus) {
		this.compStatus = compStatus;
	}
}
