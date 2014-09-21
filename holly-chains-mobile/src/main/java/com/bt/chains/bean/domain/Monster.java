package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

@ApiObject(name = "Monster", description = "怪物")
public class Monster extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2525651255897814804L;
	/**
	 * 怪兽ID
	 */
	@ApiObjectField(description = "怪兽ID")
	private int monsterId;
	/**
	 * HP:生命值
	 */
	@ApiObjectField(description = "HP:生命值")
	private int monsterD;
	/**
	 * HP Ratio:生命值率
	 */
	@ApiObjectField(description = "HP Ratio:生命值率")
	private float monsterE;
	/**
	 * DEF:防御力
	 */
	@ApiObjectField(description = "DEF:防御力")
	private int monsterF;
	/**
	 * DEF Ratio:防御力率
	 */
	@ApiObjectField(description = "DEF Ratio:防御力率")
	private float monsterG;
	/**
	 * ATK:攻击力
	 */
	@ApiObjectField(description = "ATK:攻击力")
	private int monsterH;
	/**
	 * ATK Ratio:攻击力率
	 */
	@ApiObjectField(description = "ATK Ratio:攻击力率")
	private float monsterI;
	/**
	 * 备注
	 */
	@ApiObjectField(description = "备注")
	private float remark;
	public int getMonsterId() {
		return monsterId;
	}
	public void setMonsterId(int monsterId) {
		this.monsterId = monsterId;
	}
	public int getMonsterD() {
		return monsterD;
	}
	public void setMonsterD(int monsterD) {
		this.monsterD = monsterD;
	}
	public float getMonsterE() {
		return monsterE;
	}
	public void setMonsterE(float monsterE) {
		this.monsterE = monsterE;
	}
	public int getMonsterF() {
		return monsterF;
	}
	public void setMonsterF(int monsterF) {
		this.monsterF = monsterF;
	}
	public float getMonsterG() {
		return monsterG;
	}
	public void setMonsterG(float monsterG) {
		this.monsterG = monsterG;
	}
	public int getMonsterH() {
		return monsterH;
	}
	public void setMonsterH(int monsterH) {
		this.monsterH = monsterH;
	}
	public float getMonsterI() {
		return monsterI;
	}
	public void setMonsterI(float monsterI) {
		this.monsterI = monsterI;
	}
	public float getRemark() {
		return remark;
	}
	public void setRemark(float remark) {
		this.remark = remark;
	}
	
}
