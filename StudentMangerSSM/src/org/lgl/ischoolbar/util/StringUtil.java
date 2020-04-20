package org.lgl.ischoolbar.util;

import java.util.Date;
import java.util.List;

/**
 * .ʵ�ù�����
 * @author Lenovo
 *
 */
public class StringUtil {
	/**
	 * .��ָ����list����ָ���ķָ����ָ����ַ������� 
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