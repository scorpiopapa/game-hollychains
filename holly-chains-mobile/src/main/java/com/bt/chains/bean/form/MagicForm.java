package com.bt.chains.bean.form;

import java.util.List;

import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Param;
import com.bt.chains.bean.domain.UserMagic;

@ApiObject(name = "MagicForm", description = "新增魔法")
public class MagicForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9101212733598354012L;
	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "要更新的魔法id")
	private List<Param> magicIds;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Param> getMagicIds() {
		return magicIds;
	}

	public void setMagicIds(List<Param> magicIds) {
		this.magicIds = magicIds;
	}
}
