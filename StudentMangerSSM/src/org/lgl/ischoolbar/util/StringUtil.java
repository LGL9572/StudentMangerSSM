package org.lgl.ischoolbar.util;

import java.util.Date;
import java.util.List;

/**
 * .实用工具类
 * @author Lenovo
 *
 */
public class StringUtil {
	/**
	 * .将指定的list按照指定的分隔符分隔成字符串返回 
	 * @param list
	 * @param split
	 * @return
	 */
	public static String joinString(List<Long> list ,String split) {
		String ret = "";
		for (Long l : list) {
			ret += l + split;
		}
		if(!"".equals(ret)) {
			ret = ret.substring(0, ret.length()-split.length());
		}
		return ret;
	}
	
	public static String generateSn(String perfix,String suffix) {
		return perfix + new Date().getTime() + suffix;
	}
}
