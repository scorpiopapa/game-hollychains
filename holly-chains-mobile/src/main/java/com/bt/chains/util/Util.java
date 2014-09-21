package com.bt.chains.util;

import java.util.ArrayList;
import java.util.List;

public class Util {
	/**
	 * 截取字符串
	 */
	public static List<Integer> splitStr(String str, String sign){
		List<Integer> list = null;
		if(str != null && !"".equals(str)){
			if(!(sign != null && !"".equals(sign))){
				sign = ",";
			}
			String values[] = str.split(sign);
			if(values != null && values.length > 0){
				list = new ArrayList<Integer>();
				for(String value : values){
					list.add(Integer.parseInt(value));
				}
			}
		}
		return list;
	}
}
