package com.bt.chains.bean.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Param;
import com.bt.chains.bean.domain.UserWeapon;

@ApiObject(name = "WeaponSellForm", description = "武器贩卖")
public class WeaponSellForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5127226943271512118L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "贩卖武器IDS,数组格式")
	@NotEmpty
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
