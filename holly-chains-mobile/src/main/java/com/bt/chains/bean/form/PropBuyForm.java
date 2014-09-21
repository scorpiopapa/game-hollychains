package com.bt.chains.bean.form;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "PropBuyForm", description = "道具购买")
public class PropBuyForm extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2471389208362365529L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "道具ID")
	@Min(1)
	private int propId;
	
//	@ApiObjectField(description = "道具容纳的数量（如背包，武器仓库）")
//	@Min(1)
//	private int propNum;
//	
//	@ApiObjectField(description = "道具类型, 0-体力恢复剂;1-背包;2-武器仓库", allowedvalues = {"0", "1", "2"})
//	@NotEmpty
//	private String propType;
//	
//	@ApiObjectField(description = "金额")
//	@Min(1)
//	private int specialMoney;

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

//	public String getPropType() {
//		return propType;
//	}
//
//	public void setPropType(String propType) {
//		this.propType = propType;
//	}
//
//	public int getPropNum() {
//		return propNum;
//	}
//
//	public void setPropNum(int propNum) {
//		this.propNum = propNum;
//	}
//
//	public int getSpecialMoney() {
//		return specialMoney;
//	}
//
//	public void setSpecialMoney(int specialMoney) {
//		this.specialMoney = specialMoney;
//	}
}
