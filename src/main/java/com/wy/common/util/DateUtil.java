package com.wy.common.util;

import java.util.Date;

public class DateUtil {
	
	public static Date randomDate(Date beginDate,Date endDate){
		long begin = beginDate.getTime();
		long end = endDate.getTime();
		if(end<=begin){
			throw new RuntimeException("时间异常");
		}
		long l = (long)(Math.random()*(end-begin+1)+begin);
		Date result=new Date(l);
		return result;
	}
}
