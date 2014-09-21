package com.bt.chains.util;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public final class DateTimeUtils {

	private static final String DAY_PATTERN = "yyyyMMdd";
	
	public static int compareSameDay(Date d1, Date d2){
		String day1 = DateFormatUtils.format(d1, DAY_PATTERN);
		String day2 = DateFormatUtils.format(d2, DAY_PATTERN);
		
		return day1.compareTo(day2);
	}
	
	private DateTimeUtils(){}
}
