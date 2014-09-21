package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

/**
 * boss类
 */
@ApiObject(name = "Boss", description = "boss类")
public class Boss extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6935975963144108939L;
	/**
	 * bossID
	 */
	@ApiObjectField(description = "bossID")
	private int bossId;
	/**
	 * boss技能
	 */
	@ApiObjectField(description = "boss技能")
	private int bossSkill;
	/**
	 * HP:生命值
	 */
	@ApiObjectField(description = "生命值")
	private int bossD;
	/**
	 * HP Ratio生命值率
	 */
	@ApiObjectField(description = "生命值率")
	private float bossE;
	/**
	 * DEF:防御力
	 */
	@ApiObjectField(description = "防御力")
	private int bossF;
	/**
	 * DEF Ratio:防御力率
	 */
	@ApiObjectField(description = "防御率")
	private float bossG;
	/**
	 * ATK:攻击力
	 */
	@ApiObjectField(description = "攻击力")
	private int bossH;
	/**
	 * ATK Ratio:攻击力率
	 */
	@ApiObjectField(description = "攻击力率")
	private float bossI;
	/**
	 * boss概率
	 */
	@ApiObjectField(description = "boss概率")
	private float bossRate;
	public int getBossId() {
		return bossId;
	}
	public void setBossId(int bossId) {
		this.bossId = bossId;
	}
	public int getBossSkill() {
		return bossSkill;
	}
	public void setBossSkill(int bossSkill) {
		this.bossSkill = bossSkill;
	}
	public int getBossD() {
		return bossD;
	}
	public void setBossD(int bossD) {
		this.bossD = bossD;
	}
	public float getBossE() {
		return bossE;
	}
	public void setBossE(float bossE) {
		this.bossE = bossE;
	}
	public int getBossF() {
		return bossF;
	}
	public void setBossF(int bossF) {
		this.bossF = bossF;
	}
	public float getBossG() {
		return bossG;
	}
	public void setBossG(float bossG) {
		this.bossG = bossG;
	}
	public int getBossH() {
		return bossH;
	}
	public void setBossH(int bossH) {
		this.bossH = bossH;
	}
	public float getBossI() {
		return bossI;
	}
	public void setBossI(float bossI) {
		this.bossI = bossI;
	}
	public float getBossRate() {
		return bossRate;
	}
	public void setBossRate(float bossRate) {
		this.bossRate = bossRate;
	}
}
