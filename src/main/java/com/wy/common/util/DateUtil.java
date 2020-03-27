package com.wy.common.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 随机生成一个给定范围的日期
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Date randomDate(Date beginDate, Date endDate) {
		long begin = beginDate.getTime();
		long end = endDate.getTime();
		if (end <= begin) {
			throw new RuntimeException("时间异常");
		}
		long l = (long) (Math.random() * (end - begin + 1) + begin);
		Date result = new Date(l);
		return result;
	}

	/**
	 * 返回一个月的月初
	 * @param date
	 * @return
	 */
	public static Date getMonthBegin(Date date) {
		Calendar c=Calendar.getInstance();
		//初始化日期
		c.setTime(date);
		//修改日期
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 返回一个月的月末
	 * @param date
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		Date monthBegin = getMonthBegin(c.getTime());
		c.setTime(monthBegin);
		c.add(Calendar.MONTH, -1);
		return c.getTime();
	}
	
	/**
	 * 根据出生年月得到岁数
	 * @param dateOfBirth
	 * @return
	 */
	public static Integer getAge(Date dateOfBirth){
		Calendar c=Calendar.getInstance();
		//得到系统年月日
		int s_year = c.get(Calendar.YEAR);
		int s_month = c.get(Calendar.MONTH);
		int s_day = c.get(Calendar.DAY_OF_MONTH);
		//得到出生年月日
		c.setTime(dateOfBirth);
		int b_year = c.get(Calendar.YEAR);
		int b_month = c.get(Calendar.MONTH);
		int b_day = c.get(Calendar.DAY_OF_MONTH);
		//开始计算
		int age = s_year-b_year;
		//开始完善结果
		if(s_month<b_month){
			age--;
		}
		if(s_month==b_month && s_day<b_day){
			age--;
		}
		return age;
	}
}
