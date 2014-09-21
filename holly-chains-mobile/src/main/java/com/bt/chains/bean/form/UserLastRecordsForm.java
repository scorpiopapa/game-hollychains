package com.bt.chains.bean.form;

import java.util.List;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.UserLastRecord;
import com.bt.chains.bean.domain.UserRole;
import com.bt.chains.bean.domain.UserWeapon;

@Deprecated
@ApiObject(name = "UserLastRecordsForm", description = "保存用户最后信息", show=false)
public class UserLastRecordsForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2253789054304875668L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "最后一次用户选择的职业")
	private List<UserLastRecord> roles;
	
	@ApiObjectField(description = "最后一次用户选择的武器")
	private List<UserLastRecord> weapons;
	
	@ApiObjectField(description = "最后一次用户选择的魔法")
	private List<UserLastRecord> magics;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<UserLastRecord> getRoles() {
		return roles;
	}

	public void setRoles(List<UserLastRecord> roles) {
		this.roles = roles;
	}

	public List<UserLastRecord> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<UserLastRecord> weapons) {
		this.weapons = weapons;
	}

	public List<UserLastRecord> getMagics() {
		return magics;
	}

	public void setMagics(List<UserLastRecord> magics) {
		this.magics = magics;
	}
}
