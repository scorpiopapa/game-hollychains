package com.bt.chains.bean.form;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Param;

//@ApiObject(name = "EnterUnLimitedCheckpointForm", description = "进入无限关卡", show=false)
public class EnterUnLimitedCheckpointForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4278647103109755462L;
	
	@ApiObjectField(description = "用户id")
	private int userId;
	
	@ApiObjectField(description = "类型，R-随机；C-自定义")
	private String type;
	
	@ApiObjectField(description = "扣除类型，0-付费币；1-无限券；2-其他")
	private String deductionType;
	
	@ApiObjectField(description = "关卡ID")
	private int sceneId;
	
	@ApiObjectField(description = "职业ID")
	private int roleId;
	
	@ApiObjectField(description = "武器IDS")
	private List<Param> weaponIds;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeductionType() {
		return deductionType;
	}

	public void setDeductionType(String deductionType) {
		this.deductionType = deductionType;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public List<Param> getWeaponIds() {
		return weaponIds;
	}

	public void setWeaponIds(List<Param> weaponIds) {
		this.weaponIds = weaponIds;
	}
}
