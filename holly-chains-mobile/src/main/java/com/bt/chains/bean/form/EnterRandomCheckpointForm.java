package com.bt.chains.bean.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Param;
import com.bt.chains.constant.RegexConstants;

@ApiObject(name = "EnterRandomCheckpointForm", description = "进入随机无限关卡")
public class EnterRandomCheckpointForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8158532761633093131L;

	@ApiObjectField(description = "用户id")
	@Min(1)
	int userId;
	
	@ApiObjectField(description = "职业id")
	@Min(1)
	int roleId;
	
//	@ApiObjectField(description = "魔法id列表")
//	List<Param> magicIds;
	
	@ApiObjectField(description = "武器id列表")
	List<Param> weaponIds;

	@ApiObjectField(description = "扣除类型，0-付费币；1-无限券")
	@Pattern(regexp=RegexConstants.PAY_TYPE)
	private String payType;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

//	public List<Param> getMagicIds() {
//		return magicIds;
//	}
//
//	public void setMagicIds(List<Param> magicIds) {
//		this.magicIds = magicIds;
//	}

	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}

	public List<Param> getWeaponIds() {
		return weaponIds;
	}

	public void setWeaponIds(List<Param> weaponIds) {
		this.weaponIds = weaponIds;
	}
}
