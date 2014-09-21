package com.bt.chains.bean.domain;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;


/**
 * 无限关卡
 * @author Administrator
 *
 */
@ApiObject(name = "LimitLessCheckPoints", description = "无限关卡")
public class LimitLessCheckPoints extends Checkpoint {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5446913421902818658L;
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
	 * boss9ID
	 */
	@ApiObjectField(description = "Boss9")
	private int boss9Id;
	/**
	 * boss9概率
	 */
	@ApiObjectField(description = "Boss9 Rate")
	private float boss9Rate;
	/**
	 * boss10ID
	 */
	@ApiObjectField(description = "Boss10")
	private int boss10Id;
	/**
	 * boss10概率
	 */
	@ApiObjectField(description = "Boss10 Rate")
	private float boss10Rate;
	/**
	 * boss11ID
	 */
	@ApiObjectField(description = "Boss11")
	private int boss11Id;
	/**
	 * boss11概率
	 */
	@ApiObjectField(description = "Boss11 Rate")
	private float boss11Rate;
	/**
	 * boss12ID
	 */
	@ApiObjectField(description = "Boss12")
	private int boss12Id;
	/**
	 * boss12概率
	 */
	@ApiObjectField(description = "Boss12 Rate")
	private float boss12Rate;
	/**
	 * boss13ID
	 */
	@ApiObjectField(description = "Boss13")
	private int boss13Id;
	/**
	 * boss13概率
	 */
	@ApiObjectField(description = "Boss13 Rate")
	private float boss13Rate;
	/**
	 * boss14ID
	 */
	@ApiObjectField(description = "Boss14")
	private int boss14Id;
	/**
	 * boss14概率
	 */
	@ApiObjectField(description = "Boss14 Rate")
	private float boss14Rate;
	/**
	 * boss15ID
	 */
	@ApiObjectField(description = "Boss15")
	private int boss15Id;
	/**
	 * boss15概率
	 */
	@ApiObjectField(description = "Boss15 Rate")
	private float boss15Rate;
	/**
	 * boss16ID
	 */
	@ApiObjectField(description = "Boss16")
	private int boss16Id;
	/**
	 * boss16概率
	 */
	@ApiObjectField(description = "Boss16 Rate")
	private float boss16Rate;
	/**
	 * boss17ID
	 */
	@ApiObjectField(description = "Boss17")
	private int boss17Id;
	/**
	 * boss17概率
	 */
	@ApiObjectField(description = "Boss17 Rate")
	private float boss17Rate;
	/**
	 * boss18ID
	 */
	@ApiObjectField(description = "Boss18")
	private int boss18Id;
	/**
	 * boss18概率
	 */
	@ApiObjectField(description = "Boss18 Rate")
	private float boss18Rate;
	/**
	 * boss19ID
	 */
	@ApiObjectField(description = "Boss19")
	private int boss19Id;
	/**
	 * boss19概率
	 */
	@ApiObjectField(description = "Boss19 Rate")
	private float boss19Rate;
	/**
	 * boss20ID
	 */
	@ApiObjectField(description = "Boss20")
	private int boss20Id;
	/**
	 * boss20概率
	 */
	@ApiObjectField(description = "Boss20 Rate")
	private float boss20Rate;
	/**
	 * 关卡状态
	 */
	@ApiObjectField(description = "是否开放")
	private String status;
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
	public int getBoss9Id() {
		return boss9Id;
	}
	public void setBoss9Id(int boss9Id) {
		this.boss9Id = boss9Id;
	}
	public float getBoss9Rate() {
		return boss9Rate;
	}
	public void setBoss9Rate(float boss9Rate) {
		this.boss9Rate = boss9Rate;
	}
	public int getBoss10Id() {
		return boss10Id;
	}
	public void setBoss10Id(int boss10Id) {
		this.boss10Id = boss10Id;
	}
	public float getBoss10Rate() {
		return boss10Rate;
	}
	public void setBoss10Rate(float boss10Rate) {
		this.boss10Rate = boss10Rate;
	}
	public int getBoss11Id() {
		return boss11Id;
	}
	public void setBoss11Id(int boss11Id) {
		this.boss11Id = boss11Id;
	}
	public float getBoss11Rate() {
		return boss11Rate;
	}
	public void setBoss11Rate(float boss11Rate) {
		this.boss11Rate = boss11Rate;
	}
	public int getBoss12Id() {
		return boss12Id;
	}
	public void setBoss12Id(int boss12Id) {
		this.boss12Id = boss12Id;
	}
	public float getBoss12Rate() {
		return boss12Rate;
	}
	public void setBoss12Rate(float boss12Rate) {
		this.boss12Rate = boss12Rate;
	}
	public int getBoss13Id() {
		return boss13Id;
	}
	public void setBoss13Id(int boss13Id) {
		this.boss13Id = boss13Id;
	}
	public float getBoss13Rate() {
		return boss13Rate;
	}
	public void setBoss13Rate(float boss13Rate) {
		this.boss13Rate = boss13Rate;
	}
	public int getBoss14Id() {
		return boss14Id;
	}
	public void setBoss14Id(int boss14Id) {
		this.boss14Id = boss14Id;
	}
	public float getBoss14Rate() {
		return boss14Rate;
	}
	public void setBoss14Rate(float boss14Rate) {
		this.boss14Rate = boss14Rate;
	}
	public int getBoss15Id() {
		return boss15Id;
	}
	public void setBoss15Id(int boss15Id) {
		this.boss15Id = boss15Id;
	}
	public float getBoss15Rate() {
		return boss15Rate;
	}
	public void setBoss15Rate(float boss15Rate) {
		this.boss15Rate = boss15Rate;
	}
	public int getBoss16Id() {
		return boss16Id;
	}
	public void setBoss16Id(int boss16Id) {
		this.boss16Id = boss16Id;
	}
	public float getBoss16Rate() {
		return boss16Rate;
	}
	public void setBoss16Rate(float boss16Rate) {
		this.boss16Rate = boss16Rate;
	}
	public int getBoss17Id() {
		return boss17Id;
	}
	public void setBoss17Id(int boss17Id) {
		this.boss17Id = boss17Id;
	}
	public float getBoss17Rate() {
		return boss17Rate;
	}
	public void setBoss17Rate(float boss17Rate) {
		this.boss17Rate = boss17Rate;
	}
	public int getBoss18Id() {
		return boss18Id;
	}
	public void setBoss18Id(int boss18Id) {
		this.boss18Id = boss18Id;
	}
	public float getBoss18Rate() {
		return boss18Rate;
	}
	public void setBoss18Rate(float boss18Rate) {
		this.boss18Rate = boss18Rate;
	}
	public int getBoss19Id() {
		return boss19Id;
	}
	public void setBoss19Id(int boss19Id) {
		this.boss19Id = boss19Id;
	}
	public float getBoss19Rate() {
		return boss19Rate;
	}
	public void setBoss19Rate(float boss19Rate) {
		this.boss19Rate = boss19Rate;
	}
	public int getBoss20Id() {
		return boss20Id;
	}
	public void setBoss20Id(int boss20Id) {
		this.boss20Id = boss20Id;
	}
	public float getBoss20Rate() {
		return boss20Rate;
	}
	public void setBoss20Rate(float boss20Rate) {
		this.boss20Rate = boss20Rate;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
