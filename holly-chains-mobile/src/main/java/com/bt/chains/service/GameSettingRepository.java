package com.bt.chains.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bt.chains.mapper.GameMapper;

@Repository
public class GameSettingRepository {
	public static final String USER_INIT_MONEY = "user.init.money";
	public static final String USER_INIT_SPECIAL_MONEY = "user.init.specialmoney";
	public static final String USER_INIT_CAR_COLOR  = "user.init.car.color";
	public static final String FUEL_UNIT  = "fuel.unit";
	public static final String PVP_QUIT_WIN  = "pvp.quit.win";
	public static final String PVP_QUIT_LOSE  = "pvp.quit.lose";
	public static final String USER_BAG  = "user.bag";
	public static final String USER_STORE  = "user.store";
	public static final String MONTH_SHIFT  = "test.month.shift";
	
	@Autowired
	private GameMapper mapper;

	public String getString(String key){
		return StringUtils.trimToEmpty(mapper.selectConfig(key));
	}
	
	public int getInt(String key){
		String value = getString(key);
		return StringUtils.isEmpty(value) ? 0 : Integer.valueOf(value);
	}
}
