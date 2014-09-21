package com.bt.chains.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class DBUtils {

	private final static Calendar calc = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
	
	public static Date getCurrentTimestamp(){
		return calc.getTime();
	}
	
//	public static int getIntValue()
	private DBUtils(){}
}
