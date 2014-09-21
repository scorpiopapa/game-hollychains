package com.bt.chains.bean.form;

import java.util.List;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.Param;

@Deprecated
@ApiObject(name = "MagicSellForm", description = "魔法贩卖", show=false)
public class MagicSellForm extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8073686411812482828L;

	@ApiObjectField(description = "用户ID")
	@Min(1)
	private int userId;
	
	@ApiObjectField(description = "贩卖魔法IDS，需要贩卖的魔法的ID数组")
	@NotEmpty
	private List<Param> magicIds;
	
	@ApiObjectField(description = "卖出的总金额")
	@Min(1)
	private int sellTotal;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSellTotal() {
		return sellTotal;
	}

	public void setSellTotal(int sellTotal) {
		this.sellTotal = sellTotal;
	}

	public List<Param> getMagicIds() {
		return magicIds;
	}

	public void setMagicIds(List<Param> magicIds) {
		this.magicIds = magicIds;
	}
}
