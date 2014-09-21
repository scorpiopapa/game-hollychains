package com.bt.chains.service;

import com.bt.chains.bean.domain.User;
import com.bt.chains.constant.Constants;

public final class ServiceHelper {

	/**
	 * 计算用户余额
	 * @param userId
	 * @param paymentType
	 * @return
	 */
	static int calculateBalance(User user, int userId, int paymentType, int moneyCost, int specialMoneyCost){
		int delt;
		
		if(Constants.PaymentType.PayCoin == paymentType){
			delt = user.getSpecialMoney() - specialMoneyCost;
		}else{
			delt = user.getMoney() - moneyCost;
		}
		
		return delt;
	}

	private ServiceHelper(){}
}
