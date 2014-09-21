package com.bt.chains.service;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.chains.bean.domain.User;
import com.bt.chains.bean.domain.UserAuth;
import com.bt.chains.bean.domain.UserProp;
import com.bt.chains.constant.DBConstants;
import com.bt.chains.constant.ErrorCodeConstants;
import com.bt.chains.exception.RequestException;
import com.bt.chains.mapper.UserMapper;
import com.bt.chains.util.DBUtils;

@Service
public class ValidationService {
	private final static Logger log = LoggerFactory.getLogger(ValidationService.class);
	
	@Autowired
	private UserMapper userMapper;
	
	public void validateBindStatus(int userId) throws RequestException{
		User user = userMapper.selectUser(userId);
		if(user == null){
			throw new RequestException(ErrorCodeConstants.USER_NOEXISTS, ErrorCodeConstants.USER_NOEXISTS_MSG);
		}
	}
	
	public UserAuth validateBindDevice(int userId, String code) throws RequestException {
		validateBindStatus(userId);
		
		UserAuth userAuth = userMapper.selectUserAuth(userId);
		if(userAuth == null){
			throw new RequestException(ErrorCodeConstants.INVALID_MIGRATE, ErrorCodeConstants.INVALID_MIGRATE_MSG);
		}
		
		Date createDate = userAuth.getCreateDate();
		Date expireDate = DateUtils.addDays(createDate, DBConstants.codeExpired.expiredDate);
		Date today = DBUtils.getCurrentTimestamp();
		
		if(today.compareTo(expireDate) >= 0){
			//过期
			throw new RequestException(ErrorCodeConstants.CODE_EXPIRED, ErrorCodeConstants.CODE_EXPIRED_MSG);
		}
		
		if(!userAuth.getCode().equalsIgnoreCase(code)){
			throw new RequestException(ErrorCodeConstants.CODE_MISMATCH, ErrorCodeConstants.CODE_MISMATCH_MSG);
		}
		return userAuth;
		
	}
	/**
	 * 判断宝石是否充足
	 * @throws RequestException
	 */
	public void validateGem(int userId, int gemNumber) throws RequestException {
		User user = userMapper.selectUser(userId);
		int specialMoney = user.getSpecialMoney(); 
		if(specialMoney < gemNumber){
			throw new RequestException(ErrorCodeConstants.NOT_ENOUGH_GEM, ErrorCodeConstants.NOT_ENOUGH_GEM_MSG);
		}
	}
	/**
	 * 判断武器制造券是否充足
	 * @throws RequestException
	 */
	public void validateWeaponSecurities(int userId, int number) throws RequestException {
		//获取用户武器制造券个数
		UserProp up = new UserProp();
		up.setUserId(userId);
		up.setPropType("3");
		int count = userMapper.queryUserPropCount(up);
		int weaponSecurities = 0;
		if(count > 0){
			weaponSecurities = userMapper.queryUserPropNum(userId, "3");
		}
		if(weaponSecurities < number){
			throw new RequestException(ErrorCodeConstants.NOT_ENOUGH_WEAPON_SECURITIES, ErrorCodeConstants.NOT_ENOUGH_WEAPON_SECURITIES_MSG);
		}
	}
}
