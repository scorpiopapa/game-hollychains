package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

/**
 * 普通关卡
 * @author Administrator
 *
 */
@ApiObject(name = "OrdinaryCheckPoints", description = "普通关卡")
public class OrdinaryCheckPoints extends Checkpoint{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8216792854864824143L;
	/**
	 * 关卡ID
	 */
	@ApiObjectField(description = "关卡ID")
	private int sceneId;
	/**
	 * Boss第一次出现回合数:A
	 */
	@ApiObjectField(description = "Boss第一次出现回合数:A")
	private int bossRound;
	/**
	 * Boss出现系数
	 */
	@ApiObjectField(description = "Boss出现系数")
	private float bossFeqFactor;
	/**
	 * Boss出现最小回合:C
	 */
	@ApiObjectField(description = "Boss出现最小回合:C")
	private int bossMinRound;
	/**
	 * 怪兽出现概率
	 */
	@ApiObjectField(description = "monsterRate")
	private float monsterRate;
	/**
	 * 金币出现概率
	 */
	@ApiObjectField(description = "coinRate")
	private float coinRate;
	/**
	 * 血量出现概率
	 */
	@ApiObjectField(description = "potionRate")
	private float potionRate;
	/**
	 * 盾出现概率
	 */
	@ApiObjectField(description = "sheildRate")
	private float sheildRate;
	/**
	 * 剑出现概率
	 */
	@ApiObjectField(description = "swordRate")
	private float swordRate;
	/**
	 * 弓出现概率
	 */
	@ApiObjectField(description = "bowRate")
	private float bowRate;
	/**
	 * 怪兽1ID
	 */
	@ApiObjectField(description = "Monster1")
	private int monster1Id;
	/**
	 * 怪兽1概率
	 */
	@ApiObjectField(description = "Monster1 Rate")
	private float monster1Rate;
	/**
	 * 怪兽2ID
	 */
	@ApiObjectField(description = "Monster2")
	private int monster2Id;
	/**
	 * 怪兽2概率
	 */
	@ApiObjectField(description = "Monster2 Rate")
	private float monster2Rate;
	/**
	 * 怪兽3ID
	 */
	@ApiObjectField(description = "Monster3")
	private int monster3Id;
	/**
	 * 怪兽3概率
	 */
	@ApiObjectField(description = "Monster3 Rate")
	private float monster3Rate;
	/**
	 * 剑所对应的金币
	 */
	@ApiObjectField(description = "reward coin")
	private int rewardCoin;
	/**
	 * 武器1ID
	 */
	@ApiObjectField(description = "reward weapon1")
	private int rewardWeapon1;
	/**
	 * 武器2ID
	 */
	@ApiObjectField(description = "reward weapon2")
	private int rewardWeapon2;
	/**
	 * 武器3ID
	 */
	@ApiObjectField(description = "reward weapon3")
	private int rewardWeapon3;
	/**
	 * 武器4ID
	 */
	@ApiObjectField(description = "reward weapon4")
	private int rewardWeapon4;
	/**
	 * 武器4概率
	 */
	@ApiObjectField(description = "reward weapon4 rate")
	private float rewardWeapon4Rate;
	
	/**
	 * 胜利条件：coin
	 */
	@ApiObjectField(description = "胜利条件：coin")
	private int victoryConditionsCoin;
	/**
	 * 胜利条件：回合数
	 */
	@ApiObjectField(description = "胜利条件：回合数")
	private int victoryConditionsRound;
	/**
	 * 胜利条件：小怪数
	 */
	@ApiObjectField(description = "胜利条件：小怪数")
	private int smallMonsterNum;
	/**
	 * 胜利条件：积分
	 */
	@ApiObjectField(description = "胜利条件：积分")
	private int victoryConditionsScore;
	/**
	 * 胜利条件：boss1
	 */
	@ApiObjectField(description = "胜利条件：boss1")
	private int victoryConditionsBoss1;
	/**
	 * 胜利条件：boss1数
	 */
	@ApiObjectField(description = "胜利条件：boss1数")
	private int victoryConditionsBoss1Num;
	/**
	 * 胜利条件：boss2
	 */
	@ApiObjectField(description = "胜利条件：boss2")
	private int victoryConditionsBoss2;
	/**
	 * 胜利条件：boss2数
	 */
	@ApiObjectField(description = "胜利条件：boss2数")
	private int victoryConditionsBoss2Num;
	/**
	 * 胜利条件：boss3
	 */
	@ApiObjectField(description = "胜利条件：boss3")
	private int victoryConditionsBoss3;
	/**
	 * 胜利条件：boss3数
	 */
	@ApiObjectField(description = "胜利条件：boss3数")
	private int victoryConditionsBoss3Num;
	
	/**
	 * boss1ID
	 */
	@ApiObjectField(description = "Boss1")
	private int boss1Id;
	/**
	 * boss1概率
	 */
	@ApiObjectField(description = "Boss1 Rate")
	private float boss1Rate;
	/**
	 * boss2ID
	 */
	@ApiObjectField(description = "Boss2")
	private int boss2Id;
	/**
	 * boss2概率
	 */
	@ApiObjectField(description = "Boss2 Rate")
	private float boss2Rate;
	/**
	 * boss3ID
	 */
	@ApiObjectField(description = "Boss3")
	private int boss3Id;
	/**
	 * boss3概率
	 */
	@ApiObjectField(description = "Boss3 Rate")
	private float boss3Rate;
	/**
	 * boss4ID
	 */
	@ApiObjectField(description = "Boss4")
	private int boss4Id;
	/**
	 * boss4概率
	 */
	@ApiObjectField(description = "Boss4 Rate")
	private float boss4Rate;
	/**
	 * boss5ID
	 */
	@ApiObjectField(description = "Boss5")
	private int boss5Id;
	/**
	 * boss5概率
	 */
	@ApiObjectField(description = "Boss5 Rate")
	private float boss5Rate;
	/**
	 * boss6ID
	 */
	@ApiObjectField(description = "Boss6")
	private int boss6Id;
	/**
	 * boss6概率
	 */
	@ApiObjectField(description = "Boss6 Rate")
	private float boss6Rate;
	/**
	 * boss7ID
	 */
	@ApiObjectField(description = "Boss7")
	private int boss7Id;
	/**
	 * boss7概率
	 */
	@ApiObjectField(description = "Boss7 Rate")
	private float boss7Rate;
	/**
	 * boss8ID
	 */
	@ApiObjectField(description = "Boss8")
	private int boss8Id;
	/**
	 * boss8概率
	 */
	@ApiObjectField(description = "Boss8 Rate")
	private float boss8Rate;
	/**
	 * 关卡状态
	 */
	@ApiObjectField(description = "是否开放")
	private String status;
	public int getSceneId() {
		return sceneId;
	}
	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}
	public int getBossRound() {
		return bossRound;
	}
	public void setBossRound(int bossRound) {
		this.bossRound = bossRound;
	}
	public float getBossFeqFactor() {
		return bossFeqFactor;
	}
	public void setBossFeqFactor(float bossFeqFactor) {
		this.bossFeqFactor = bossFeqFactor;
	}
	public int getBossMinRound() {
		return bossMinRound;
	}
	public void setBossMinRound(int bossMinRound) {
		this.bossMinRound = bossMinRound;
	}
	public float getMonsterRate() {
		return monsterRate;
	}
	public void setMonsterRate(float monsterRate) {
		this.monsterRate = monsterRate;
	}
	public float getCoinRate() {
		return coinRate;
	}
	public void setCoinRate(float coinRate) {
		this.coinRate = coinRate;
	}
	public float getPotionRate() {
		return potionRate;
	}
	public void setPotionRate(float potionRate) {
		this.potionRate = potionRate;
	}
	public float getSheildRate() {
		return sheildRate;
	}
	public void setSheildRate(float sheildRate) {
		this.sheildRate = sheildRate;
	}
	public float getSwordRate() {
		return swordRate;
	}
	public void setSwordRate(float swordRate) {
		this.swordRate = swordRate;
	}
	public float getBowRate() {
		return bowRate;
	}
	public void setBowRate(float bowRate) {
		this.bowRate = bowRate;
	}
	public int getMonster1Id() {
		return monster1Id;
	}
	public void setMonster1Id(int monster1Id) {
		this.monster1Id = monster1Id;
	}
	public float getMonster1Rate() {
		return monster1Rate;
	}
	public void setMonster1Rate(float monster1Rate) {
		this.monster1Rate = monster1Rate;
	}
	public int getMonster2Id() {
		return monster2Id;
	}
	public void setMonster2Id(int monster2Id) {
		this.monster2Id = monster2Id;
	}
	public float getMonster2Rate() {
		return monster2Rate;
	}
	public void setMonster2Rate(float monster2Rate) {
		this.monster2Rate = monster2Rate;
	}
	public int getMonster3Id() {
		return monster3Id;
	}
	public void setMonster3Id(int monster3Id) {
		this.monster3Id = monster3Id;
	}
	public float getMonster3Rate() {
		return monster3Rate;
	}
	public void setMonster3Rate(float monster3Rate) {
		this.monster3Rate = monster3Rate;
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
	public int getVictoryConditionsCoin() {
		return victoryConditionsCoin;
	}
	public void setVictoryConditionsCoin(int victoryConditionsCoin) {
		this.victoryConditionsCoin = victoryConditionsCoin;
	}
	public int getVictoryConditionsRound() {
		return victoryConditionsRound;
	}
	public void setVictoryConditionsRound(int victoryConditionsRound) {
		this.victoryConditionsRound = victoryConditionsRound;
	}
	public int getSmallMonsterNum() {
		return smallMonsterNum;
	}
	public void setSmallMonsterNum(int smallMonsterNum) {
		this.smallMonsterNum = smallMonsterNum;
	}
	public int getVictoryConditionsScore() {
		return victoryConditionsScore;
	}
	public void setVictoryConditionsScore(int victoryConditionsScore) {
		this.victoryConditionsScore = victoryConditionsScore;
	}
	public int getVictoryConditionsBoss1() {
		return victoryConditionsBoss1;
	}
	public void setVictoryConditionsBoss1(int victoryConditionsBoss1) {
		this.victoryConditionsBoss1 = victoryConditionsBoss1;
	}
	public int getVictoryConditionsBoss1Num() {
		return victoryConditionsBoss1Num;
	}
	public void setVictoryConditionsBoss1Num(int victoryConditionsBoss1Num) {
		this.victoryConditionsBoss1Num = victoryConditionsBoss1Num;
	}
	public int getVictoryConditionsBoss2() {
		return victoryConditionsBoss2;
	}
	public void setVictoryConditionsBoss2(int victoryConditionsBoss2) {
		this.victoryConditionsBoss2 = victoryConditionsBoss2;
	}
	public int getVictoryConditionsBoss2Num() {
		return victoryConditionsBoss2Num;
	}
	public void setVictoryConditionsBoss2Num(int victoryConditionsBoss2Num) {
		this.victoryConditionsBoss2Num = victoryConditionsBoss2Num;
	}
	public int getVictoryConditionsBoss3() {
		return victoryConditionsBoss3;
	}
	public void setVictoryConditionsBoss3(int victoryConditionsBoss3) {
		this.victoryConditionsBoss3 = victoryConditionsBoss3;
	}
	public int getVictoryConditionsBoss3Num() {
		return victoryConditionsBoss3Num;
	}
	public void setVictoryConditionsBoss3Num(int victoryConditionsBoss3Num) {
		this.victoryConditionsBoss3Num = victoryConditionsBoss3Num;
	}
	public int getBoss1Id() {
		return boss1Id;
	}
	public void setBoss1Id(int boss1Id) {
		this.boss1Id = boss1Id;
	}
	public float getBoss1Rate() {
		return boss1Rate;
	}
	public void setBoss1Rate(float boss1Rate) {
		this.boss1Rate = boss1Rate;
	}
	public int getBoss2Id() {
		return boss2Id;
	}
	public void setBoss2Id(int boss2Id) {
		this.boss2Id = boss2Id;
	}
	public float getBoss2Rate() {
		return boss2Rate;
	}
	public void setBoss2Rate(float boss2Rate) {
		this.boss2Rate = boss2Rate;
	}
	public int getBoss3Id() {
		return boss3Id;
	}
	public void setBoss3Id(int boss3Id) {
		this.boss3Id = boss3Id;
	}
	public float getBoss3Rate() {
		return boss3Rate;
	}
	public void setBoss3Rate(float boss3Rate) {
		this.boss3Rate = boss3Rate;
	}
	public int getBoss4Id() {
		return boss4Id;
	}
	public void setBoss4Id(int boss4Id) {
		this.boss4Id = boss4Id;
	}
	public float getBoss4Rate() {
		return boss4Rate;
	}
	public void setBoss4Rate(float boss4Rate) {
		this.boss4Rate = boss4Rate;
	}
	public int getBoss5Id() {
		return boss5Id;
	}
	public void setBoss5Id(int boss5Id) {
		this.boss5Id = boss5Id;
	}
	public float getBoss5Rate() {
		return boss5Rate;
	}
	public void setBoss5Rate(float boss5Rate) {
		this.boss5Rate = boss5Rate;
	}
	public int getBoss6Id() {
		return boss6Id;
	}
	public void setBoss6Id(int boss6Id) {
		this.boss6Id = boss6Id;
	}
	public float getBoss6Rate() {
		return boss6Rate;
	}
	public void setBoss6Rate(float boss6Rate) {
		this.boss6Rate = boss6Rate;
	}
	public int getBoss7Id() {
		return boss7Id;
	}
	public void setBoss7Id(int boss7Id) {
		this.boss7Id = boss7Id;
	}
	public float getBoss7Rate() {
		return boss7Rate;
	}
	public void setBoss7Rate(float boss7Rate) {
		this.boss7Rate = boss7Rate;
	}
	public int getBoss8Id() {
		return boss8Id;
	}
	public void setBoss8Id(int boss8Id) {
		this.boss8Id = boss8Id;
	}
	public float getBoss8Rate() {
		return boss8Rate;
	}
	public void setBoss8Rate(float boss8Rate) {
		this.boss8Rate = boss8Rate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
