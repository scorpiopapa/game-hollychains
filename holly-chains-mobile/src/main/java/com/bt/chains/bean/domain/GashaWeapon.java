package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "gashaWeapons", description = "购买武器返回的武器信息")
public class GashaWeapon extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3011388833123594259L;
	@ApiObjectField(description = "武器WID")
	private int wId;
	@ApiObjectField(description = "是否新武器，1:新武器，0:旧武器")
	private int status;
	public int getwId() {
		return wId;
	}
	public void setwId(int wId) {
		this.wId = wId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
