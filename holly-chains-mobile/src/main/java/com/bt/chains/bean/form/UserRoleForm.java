package com.bt.chains.bean.form;

import java.util.List;
import javax.validation.constraints.Min;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.UserRole;

@Deprecated
@ApiObject(name = "UserRoleForm", description = "新增用户角色", show=false)
public class UserRoleForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2322060260394921790L;
	
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
//	@ApiObjectField(description = "职业列表数据，数组格式")
//	private List<UserRole> roles;
	
	@ApiObjectField(description = "职业ID")
	int roleId;
	
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

//	public List<UserRole> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<UserRole> roles) {
//		this.roles = roles;
//	}
}
