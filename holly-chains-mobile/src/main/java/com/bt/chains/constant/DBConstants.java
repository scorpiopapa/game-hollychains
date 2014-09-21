package com.bt.chains.constant;

public final class DBConstants {
	public static final String YES = "Y";
	public static final String NO = "N";
	
	/**
	 * 体力值
	 */
	public static final int POWER = 999;
	
	public static class Market{
		public static final String Google = "G";
		public static final String Apple = "A";
	}
	
	public static class Achievement{
		public static final String Daily = "D";
		public static final String Permanent = "P";
	}
	
	public static class CostType{
		public static final String Money = "M";
		public static final String SpecialMoney = "S";
	}
	
	public static class RewardType{
		public static final int DailyLogin= 1;
		public static final int LoginSum = 2;
		public static final int Common = 3;
		public static final int Elite = 4;
		public static final int Hero = 5;
		public static final int MoneySum = 6;
		public static final int SpecialMoneySum = 7;
		public static final int Challenge = 8;
	}

	public static class RewardValueType{
		public static final int money= 1;
		public static final int specialMoney = 2;
		public static final int weapon = 3;
		public static final int prop = 4;
		public static final int strength = 5;
	}
	public static class LastRecordType{
		public static final int Role = 0;
		public static final int Weapon = 1;
		public static final int Magic = 2;
	}
	
	public static class InUseStatus{
		public static final int NotInUse = 0;
		public static final int InUse = 1;
	}
	private DBConstants(){}
	
	/**
	 * 默认的用户职业
	 */
	public static class DefUserRole{
		public static final int roleId = 1;
		public static final int roleRank = 1;
	}
	/**
	 * 切换码过期时间
	 */
	public static class codeExpired{
		public static final int expiredDate = 1;
	}
	
	/**
	 * 用户道具
	 * @author sc
	 *
	 */
	public static class UserProp{
		// 0：体力恢复剂，1：背包；2：武器仓库; 3：扭蛋券；4：无限模式参加券。
		public static final int Power = 0;
		public static final int Bag = 1;
		public static final int WeaponRepository = 2;
		public static final int GashaTicket = 3;
		public static final int UnlimitCheckpointTicket = 4;
	}
	
	/**
	 * 无限模式code
	 * @author sc
	 *
	 */
	public static class UnlimitModeCode{
		public static final int UnlimitMode = 0;	// 随机无限模式
		public static final int CustomUnlimitMode = 1;	// 用户自定义无限模式
	}
	
	/**
	 * 
	 */
	public static class User{
		public static final int maxGem = 999999;
		public static final int maxMoney = 999999;
		public static final int bagStatus = 1;
	}
	
	/**
	 * 武器
	 */
	public static class Weapon{
		public static final int ComposeWeaponMoney = 50;   //武器合成-每个贡品合成需要的硬币数
	}
	
	/**
	 * 用户导航
	 */
	public static class UserNavigation{
		//0-所有引导都已完成;1-开头画面至第一关完成;2-练习装备魔法;3-练习选择副本;4-通过第二关;5-使用武器券购买武器;6-练习强化武器;7-装备新武器;8-第一次通过1018关
		public static final int NAVIGATION_FINISH = 0;
		public static final int NAVIGATION_ONE = 1;
		public static final int NAVIGATION_TWO = 2;
		public static final int NAVIGATION_THREE = 3;
		public static final int NAVIGATION_FOUR = 4;
		public static final int NAVIGATION_FIVE = 5;
		public static final int NAVIGATION_SIX = 6;
		public static final int NAVIGATION_SEVEN = 7;
		public static final int NAVIGATION_EIGHT = 8;
	}
}
