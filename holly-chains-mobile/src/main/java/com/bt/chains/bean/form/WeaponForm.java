package com.bt.chains.bean.form;

import java.util.List;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Param;

@ApiObject(name = "WeaponForm", description = "更新武器使用状态用")
public class WeaponForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -689122792529336250L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "武器id列表")
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
	
}
