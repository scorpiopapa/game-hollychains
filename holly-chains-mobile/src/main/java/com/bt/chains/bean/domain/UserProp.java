package com.bt.chains.bean.domain;

import java.util.Date;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "UserProp", description = "用户道具")
public class UserProp extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2635505015289699716L;
	
	/**
	 * 用户ID
	 */
	@ApiObjectField(description = "用户ID")
	private int userId;
	/**
	 * 道具ID
	 */
	@ApiObjectField(description = "道具ID")
	private int propId;
	/**
	 * 道具类型 0：体力恢复剂，1：背包；2：武器仓库; 3：扭蛋券；4：无限模式参加券。
	 */
	@ApiObjectField(description = "道具类型，0-体力恢复剂；1-背包；2-武器仓库")
	private String propType;
	/**
	 * 道具容纳的数量（如背包，武器仓库），或道具的个数
	 */
	@ApiObjectField(description = "道具容纳的数量（如背包，武器仓库）")
	private int propNum;
	/**
	 * 操作时间
	 */
	@ApiObjectField(description = "操作时间")
	private Date opTime;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}
	public String getPropType() {
		return propType;
	}
	public void setPropType(String propType) {
		this.propType = propType;
	}
	public int getPropNum() {
		return propNum;
	}
	public void setPropNum(int propNum) {
		this.propNum = propNum;
	}
	public Date getOpTime() {
		return opTime;
	}
	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}
}
