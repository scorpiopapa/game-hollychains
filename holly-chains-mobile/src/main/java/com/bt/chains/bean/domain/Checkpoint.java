package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.bt.chains.bean.Product;

/**
 * 关卡类
 */
@ApiObject(name = "Checkpoint", description = "关卡信息")
public class Checkpoint extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6525950462219945223L;
	/**
	 * 关卡ID
	 */
	//@ApiObjectField(description = "关卡ID")
	private int sceneId;
	
	String bigStage;
	
	String smallStage;
	
	int power;
	
	/**
	 * 剑所对应的金币
	 */
	//@ApiObjectField(description = "reward coin")
	private int rewardCoin;
	/**
	 * 武器1ID
	 */
	//@ApiObjectField(description = "reward weapon1")
	private int rewardWeapon1;
	/**
	 * 武器2ID
	 */
	//@ApiObjectField(description = "reward weapon2")
	private int rewardWeapon2;
	/**
	 * 武器3ID
	 */
	//@ApiObjectField(description = "reward weapon3")
	private int rewardWeapon3;
	/**
	 * 武器4ID
	 */
	//@ApiObjectField(description = "reward weapon4")
	private int rewardWeapon4;
	/**
	 * 武器4概率
	 */
	//@ApiObjectField(description = "reward weapon4 rate")
	private float rewardWeapon4Rate;
	
	/**
	 * 怪兽1ID
	 */
	//@ApiObjectField(description = "Monster1")
	private int monster1Id;
	/**
	 * 怪兽2ID
	 */
	//@ApiObjectField(description = "Monster2")
	private int monster2Id;
	/**
	 * 怪兽3ID
	 */
	//@ApiObjectField(description = "Monster3")
	private int monster3Id;
	public int getSceneId() {
		return sceneId;
	}
	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}
	public int getRewardCoin() {
		return rewardCoin;
	}
	public void setRewardCoin(int rewardCoin) {
		this.rewardCoin = rewardCoin;
	}
	public int getRewardWeapon1() {
		return rewardWeapon1;
	}
	public void setRewardWeapon1(int rewardWeapon1) {
		this.rewardWeapon1 = rewardWeapon1;
	}
	public int getRewardWeapon2() {
		return rewardWeapon2;
	}
	public void setRewardWeapon2(int rewardWeapon2) {
		this.rewardWeapon2 = rewardWeapon2;
	}
	public int getRewardWeapon3() {
		return rewardWeapon3;
	}
	public void setRewardWeapon3(int rewardWeapon3) {
		this.rewardWeapon3 = rewardWeapon3;
	}
	public int getRewardWeapon4() {
		return rewardWeapon4;
	}
	public void setRewardWeapon4(int rewardWeapon4) {
		this.rewardWeapon4 = rewardWeapon4;
	}
	public float getRewardWeapon4Rate() {
		return rewardWeapon4Rate;
	}
	public void setRewardWeapon4Rate(float rewardWeapon4Rate) {
		this.rewardWeapon4Rate = rewardWeapon4Rate;
	}
	public int getMonster1Id() {
		return monster1Id;
	}
	public void setMonster1Id(int monster1Id) {
		this.monster1Id = monster1Id;
	}
	public int getMonster2Id() {
		return monster2Id;
	}
	public void setMonster2Id(int monster2Id) {
		this.monster2Id = monster2Id;
	}
	public int getMonster3Id() {
		return monster3Id;
	}
	public void setMonster3Id(int monster3Id) {
		this.monster3Id = monster3Id;
	}
	public String getBigStage() {
		return bigStage;
	}
	public void setBigStage(String bigStage) {
		this.bigStage = bigStage;
	}
	public String getSmallStage() {
		return smallStage == null ? "" : smallStage;
	}
	public void setSmallStage(String smallStage) {
		this.smallStage = smallStage;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}
