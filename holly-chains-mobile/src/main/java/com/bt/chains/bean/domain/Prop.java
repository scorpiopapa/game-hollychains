package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "Prop", description = "道具菜单")
public class Prop extends Product{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8639540966454172148L;
	/**
	 * 道具ID
	 */
	@ApiObjectField(description = "道具ID")
	private int propId;
	
	@ApiObjectField(description = "道具类型,0-体力恢复剂；1-背包；2-武器仓库")
	private String propType;
	
	@ApiObjectField(description = "道具名称")
	private String propName;
	
	@ApiObjectField(description = "道具价格")
	private int propPrice;
	
	@ApiObjectField(description = "道具描述")
	private String propDescription;
	
	@ApiObjectField(description = "是否可以再购买，Y-是;N-否")
	private String status;
	
	@ApiObjectField(description = "购买数量")
	private int propNum;
	
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

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public int getPropPrice() {
		return propPrice;
	}

	public void setPropPrice(int propPrice) {
		this.propPrice = propPrice;
	}

	public String getPropDescription() {
		return propDescription;
	}

	public void setPropDescription(String propDescription) {
		this.propDescription = propDescription;
	}

	public String getStatus() {
		return status == null ? "N" : status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPropNum() {
		return propNum;
	}

	public void setPropNum(int propNum) {
		this.propNum = propNum;
	}
}
