package com.bt.chains.constant;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;


@ApiObject(name = "ErrorCodeConstants", description="错误代码", show=false)
public final class ErrorCodeConstants {
//	@ApiObjectField(description = "2-钱数不够")
	public final static String NOT_ENOUGH_MONEY = "1";
	public final static String NOT_ENOUGH_MONEY_MSG = "钱数不够";
	
////	@ApiObjectField(description = "3-重复购买")
//	public final static String DUPLICATE_SUBMIT = "3";
//	public final static String DUPLICATE_SUBMIT_MSG = "重复提交";
//	
//	@ApiObjectField(description = "4-购买车名时传入的车名为空")
	public final static String ROLE_NO_EXISTS = "4";
	public final static String ROLE_NO_EXISTS_MSG = "职业不存在";
//	
////	@ApiObjectField(description = "5-购买车牌时传入的车牌为空")
//	public final static String EMPTY_CAR_BAND = "5";
//	public final static String EMPTY_CAR_BAND_MSG = "购买车牌时传入的车牌为空";
//	
//	public final static String NO_CAR = "6";
//	public final static String NO_CAR_MSG = "用户没有任何赛车";
//
//	public final static String INVALID_CAR_ID = "7";
//	public final static String INVALID_CAR_ID_MSG = "购买车名时传入的赛车id非法";
//
//	public final static String INVALID_RANK = "8";
//	public final static String INVALID_RANK_MSG = "目标等级非法";

	public final static String INTERNAL_ERROR = "100";
	public final static String INTERNAL_ERROR_MSG = "内部错误";
	
	@ApiObjectField(description = "13-用户不存在")
	public final static String USER_NOEXISTS = "13";
	public final static String USER_NOEXISTS_MSG = "用户不存在";
	
	@ApiObjectField(description = "10-设备关联失败")
	public final static String INVALID_MIGRATE = "10";
	public final static String INVALID_MIGRATE_MSG = "设备关联失败";
	
	@ApiObjectField(description = "11-验证码过期")
	public final static String CODE_EXPIRED = "11";
	public final static String CODE_EXPIRED_MSG = "验证码过期";

	@ApiObjectField(description = "12-验证码不匹配")
	public final static String CODE_MISMATCH = "12";
	public final static String CODE_MISMATCH_MSG = "验证码不匹配";
	
	@ApiObjectField(description = "13-无限模式券不够")
	public final static String NOT_ENOUGH_UNLIMITED_SECURITIES = "13";
	public final static String NOT_ENOUGH_UNLIMITED_SECURITIES_MSG = "无限模式券不足，无法进入关卡";
	
	@ApiObjectField(description = "14-体力不足")
	public final static String NOT_ENOUGH_POWER = "14";
	public final static String NOT_ENOUGH_POWER_MSG = "体力不足，无法进入关卡";
	
	@ApiObjectField(description = "15-武器制造券不足")
	public final static String NOT_ENOUGH_WEAPON_SECURITIES = "15";
	public final static String NOT_ENOUGH_WEAPON_SECURITIES_MSG = "武器制造券不足，无法购买武器";
	
	@ApiObjectField(description = "16-宝石余额不足")
	public final static String NOT_ENOUGH_GEM = "16";
	public final static String NOT_ENOUGH_GEM_MSG = "宝石余额不足";
	
	@ApiObjectField(description = "17-购买武器ID参数传入错误")
	public final static String GACHA_ID_ERROR = "17";
	public final static String GACHA_ID_ERROR_MSG = "购买武器ID参数传入错误";
	
	@ApiObjectField(description = "18-武器仓库容量不足")
	public final static String NOT_ENOUGH_STROE_ERROR = "18";
	public final static String NOT_ENOUGH_STROE_MSG = "武器仓库容量不足";
	
	@ApiObjectField(description = "19-购买武器失败")
	public final static String BUY_WEAPON_ERROR = "19";
	public final static String BUY_WEAPON_MSG = "购买武器失败";
	
	@ApiObjectField(description = "20-数据不存在")
	public final static String NO_DATA_ERROR = "20";
	public final static String NO_DATA_MSG = "数据不存在";
	
	@ApiObjectField(description = "21-宝石数量超出最大值")
	public final static String GEM_MAX_ERROR = "21";
	public final static String GEM_MAX_MSG = "宝石数量超出最大值";
	
	@ApiObjectField(description = "22-武器背包容量不足")
	public final static String NOT_ENOUGH_BAG_ERROR = "22";
	public final static String NOT_ENOUGH_BAG_MSG = "武器背包容量不足";
	
	@ApiObjectField(description = "23-职业级别已经到达上限")
	public final static String ROLE_MAX = "23";
	public final static String ROLE_MAX_MSG = "职业级别已经到达上限";
	
	@ApiObjectField(description = "24-导航插入数据重复")
	public final static String NAVIGATION_EQUAL = "24";
	public final static String NAVIGATION_EQUAL_MSG = "导航插入数据重复";
	
	private ErrorCodeConstants(){}
}
