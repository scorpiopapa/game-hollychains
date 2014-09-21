package com.bt.chains.bean.view;

import java.util.List;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;
import com.bt.chains.bean.domain.BaseData;
import com.bt.chains.bean.domain.Boss;
import com.bt.chains.bean.domain.Checkpoint;
import com.bt.chains.bean.domain.Monster;
import com.bt.chains.bean.domain.User;

@ApiObject(name = "CheckpointsView", description = "选择关卡")
public class CheckpointsView extends com.joinway.bean.view.View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4592602726437869655L;
	
	@ApiObjectField(description = "关卡信息")
	private Checkpoint checkpoints;
	
	@ApiObjectField(description = "金币（余额）")
	private int money;
	
	@ApiObjectField(description = "宝石（余额）")
	private int specialMoney;
	
	@ApiObjectField(description = "Boss信息")
	private List<Boss> bossList;
	
	@ApiObjectField(description = "怪兽信息")
	private List<Monster> monsterList;
	
	@ApiObjectField(description = "基础数据信息")
	private List<BaseData> baseDatas ;

	public Checkpoint getCheckpoints() {
		return checkpoints;
	}

	public void setCheckpoints(Checkpoint checkpoints) {
		this.checkpoints = checkpoints;
	}

	public List<Boss> getBossList() {
		return bossList;
	}

	public void setBossList(List<Boss> bossList) {
		this.bossList = bossList;
	}

	public List<Monster> getMonsterList() {
		return monsterList;
	}

	public void setMonsterList(List<Monster> monsterList) {
		this.monsterList = monsterList;
	}

	public List<BaseData> getBaseDatas() {
		return baseDatas;
	}

	public void setBaseDatas(List<BaseData> baseDatas) {
		this.baseDatas = baseDatas;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getSpecialMoney() {
		return specialMoney;
	}

	public void setSpecialMoney(int specialMoney) {
		this.specialMoney = specialMoney;
	}
}
