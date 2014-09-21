package com.bt.chains.bean.view;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "UnLimitedCheckpointResultView", description = "无限关卡结束后用户获得的奖励")
public class UnLimitedCheckpointResultView extends com.joinway.bean.view.View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5257829770088345990L;
	
	@ApiObjectField(description = "奖励的金币")
	int money;
	
	@ApiObjectField(description = "武器序号")
	int wid;
	
	@ApiObjectField(description = "武器数量")
	int weaponCount;
	
	@ApiObjectField(description = "道具id")
	int propId;
	
	@ApiObjectField(description = "道具数量")
	int propCount;

	@ApiObjectField(description = "武器仓库是否已满:0-未满;1-已满")
	int repoStatus;

	@ApiObjectField(description = "道具类型，0-体力恢复剂；1-背包；2-武器仓库； 3-扭蛋券；4-无限模式参加券")
	int propType;
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public int getWeaponCount() {
		return weaponCount;
	}

	public void setWeaponCount(int weaponCount) {
		this.weaponCount = weaponCount;
	}

	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public int getPropCount() {
		return propCount;
	}

	public void setPropCount(int propCount) {
		this.propCount = propCount;
	}

	public int getRepoStatus() {
		return repoStatus;
	}

	public void setRepoStatus(int repoStatus) {
		this.repoStatus = repoStatus;
	}

	public int getPropType() {
		return propType;
	}

	public void setPropType(int propType) {
		this.propType = propType;
	}
	
}
