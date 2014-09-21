package com.bt.chains.bean.form;

import javax.validation.constraints.Min;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "SacrifiedWeapon", description = "武器贡品")
public class SacrifiedWeapon extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1860734188815585363L;

	@ApiObjectField(description = "贡品唯一标志符(主键ID)")
	@Min(1)
	int id;
	
	@ApiObjectField(description = "贡品等级")
	@Min(1)
	int rank;

//	@ApiObjectField(description = "贡品基础经验值")
//	int point;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

//	public int getPoint() {
//		return point;
//	}
//
//	public void setPoint(int point) {
//		this.point = point;
//	}
}
