package com.bt.chains.bean.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Param;

@ApiObject(name = "WeaponImportForm", description = "武器导入")
public class WeaponImportForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1299162165466335140L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "武器IDS，需要导入的所有武器ID,数组格式")
	@NotEmpty
//	private List<Param> weaponIds;
	private List<Param> ids;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Param> getIds() {
		return ids;
	}

	public void setIds(List<Param> ids) {
		this.ids = ids;
	}

//	public List<Param> getWeaponIds() {
//		return weaponIds;
//	}
//
//	public void setWeaponIds(List<Param> weaponIds) {
//		this.weaponIds = weaponIds;
//	}
	
}
