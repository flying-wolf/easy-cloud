/*
 * @(#)DateUtil.java 1.00 2004-04-12 Copyright (c) 2005 Shenzhen Surfilter
 * Network Technology Co.,Ltd. All rights reserved.
 */
package com.superm.easy.cloud.commons.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/** 
 * @author hu.sheng
 * @since 20190425
 */
public class DateUtil {

	public static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
	public static final DateFormat DATE_FORMAT2 = new SimpleDateFormat("yyyy/MM/dd");
	public static final DateFormat DEFAULT_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
	public static final DateFormat DEFAULT_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final DateFormat DATE_FORMAT_MONTH = new SimpleDateFormat("yyyyMM");
	public static final DateFormat DEFAULT_TIME_FORMAT_CN = new SimpleDateFormat("HH时mm分ss秒");

	private DateUtil() {
	}

	public static final String getYMD() {
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(now);
	}

	public static Date offsetDay(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return c.getTime();
	}

	public synchronized static String date2String(Date date, DateFormat dateFormat) {
		return dateFormat.format(date);
	}

	public static String date2String(Date date, String dateFormat) {
		return date2String(date, new SimpleDateFormat(dateFormat));
	}

	public static String date2String(Date date) {
		return date2String(date, DEFAULT_DATE_FORMAT);
	}

	public static String date2StringOther(Date date) {
		return date2String(date, DATETIME_FORMAT);
	}

	public static String date2StringAsyyyyMMdd(Date date) {
		return date2String(date, DATE_FORMAT);
	}
	
	public static String date2StringAsyyyyMMdd2(Date date) {
		return date2String(date, DATE_FORMAT2);
	}

	public static String date2StringAsyyyyMM(Date date) {
		return date2String(date, DATE_FORMAT_MONTH);
	}
	
	public synchronized static String time2String(long time, DateFormat dateFormat, String timezone) {
		Date date = new Date(time);
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		return dateFormat.format(date);
	}
	
	public synchronized static String time2String(Date time, DateFormat dateFormat) {
		return dateFormat.format(time);
	}

	public static String time2String(Date time, String dateFormat) {
		return date2String(time, new SimpleDateFormat(dateFormat));
	}

	public static String time2String(Date time) {
		return date2String(time, DEFAULT_TIME_FORMAT);
	}

	public synchronized static String dateTime2String(Date dateTime, DateFormat dateFormat) {
		return dateFormat.format(dateTime);
	}

	public static String dateTime2String(Date dateTime, String dateFormat) {
		return date2String(dateTime, dateFormat);
	}

	public static String dateTime2String(Date dateTime) {
		return date2String(dateTime, DEFAULT_DATETIME_FORMAT);
	}

	/*
	 * String -->Date
	 */

	public synchronized static Date string2Date(String date, DateFormat dateFormat) {
		try {
			return dateFormat.parse(date);
		}
		catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Date string2Date(String date, String dateFormat) {
		return string2Date(date, new SimpleDateFormat(dateFormat));
	}

	public static Date string2Date(String date) {
		return string2Date(date, DEFAULT_DATE_FORMAT);
	}

	public static Time string2Time(String time, DateFormat timeFormat) {
		return new Time(string2Date(time, timeFormat).getTime());
	}

	public static Time string2Time(String time, String timeFormat) {
		return new Time(string2Date(time, timeFormat).getTime());
	}

	public static Time string2Time(String time) {
		return string2Time(time, DEFAULT_TIME_FORMAT);
	}

	public static Timestamp string2DateTime(String time, DateFormat timeFormat) {
		return new Timestamp(string2Date(time, timeFormat).getTime());
	}

	public static Timestamp string2DateTime(String time, String timeFormat) {
		return new Timestamp(string2Date(time, timeFormat).getTime());
	}

	public static Timestamp string2DateTime(String time) {
		return string2DateTime(time, DEFAULT_DATETIME_FORMAT);
	}

	public static Timestamp string2DateTimeOther(String time) {
		return string2DateTime(time, DATETIME_FORMAT);
	}

	public synchronized static String getCurrentDateAsString() {
		return DEFAULT_DATE_FORMAT.format(Calendar.getInstance().getTime());
	}

	public synchronized static String getCurrentDateTimeAsString() {
		return DEFAULT_DATETIME_FORMAT.format(Calendar.getInstance().getTime());
	}

	public static String getCurrentDateAsString(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(Calendar.getInstance().getTime());
	}

	public static String getDateString(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}

	public static Date parseDate(String date, DateFormat df) {
		try {
			return df.parse(date);
		}
		catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Date parseDate(String date, String dateFormat) {
		SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
		return parseDate(date, fmt);
	}

	public synchronized static Date parseDate(String date) {
		return parseDate(date, DEFAULT_DATETIME_FORMAT);
	}

	public static Timestamp nowTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public static String toString(Date time) {
		return getDateString(time, "yyyy-MM-dd HH:mm:ss");
	}

	public static String fromUnixTime(Long ms) {
		return getDateString(new Date(ms.longValue() * 1000), "yyyy-MM-dd HH:mm:ss");
	}

	public static Long unixTimestamp(String date) {
		return new Long(parseDate(date).getTime() / 1000);
	}

	public static Long unixTimestamp(String date, String dateFormat) {
		return new Long(parseDate(date, dateFormat).getTime() / 1000);
	}

	public static Long currentUnixTimestamp() {
		return new Long(System.currentTimeMillis() / 1000);
	}

	public static Long unixTimestamp(Date date) {
		return new Long(date.getTime() / 1000);
	}

	public static String getTimeStampNumberFormat(Timestamp formatTime) {
		SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", new Locale("zh", "cn"));
		return mFormat.format(formatTime);
	}
	
	public static String getTimeStampAsString(Timestamp formatTime) {
		SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return mFormat.format(formatTime);
	}
	
	public static String getDateAsString(Date formatTime) {
		SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return mFormat.format(formatTime);
	}
	
	/**
	 * 获得上一个时段的字符串，例：2011032117
	 * @return
	 */
	public static String getLastHour(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHH");
		Calendar cl = Calendar.getInstance();
		cl.set(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH),cl.get(Calendar.DAY_OF_MONTH),cl.get(Calendar.HOUR_OF_DAY)-1,0,0);
		return sf.format(cl.getTime());
	}

	/**
	 * 获得相差天数，取整，如1.1天为2天
	 */
	public static int getTimeDifference(Timestamp endTime, Timestamp startTime) {
		SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
		long t1 = 0L;
		long t2 = 0L;
		int days = 0;
		try {
			t1 = timeformat.parse(getTimeStampNumberFormat(endTime)).getTime();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			t2 = timeformat.parse(getTimeStampNumberFormat(startTime)).getTime();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		// 因为t1-t2得到的是毫秒级,所以要初3600000得出小时.算天数或秒同理
		if ((int) ((t1 - t2) % (3600000 * 24)) == 0) {
			days = (int) ((t1 - t2) / (3600000 * 24));
		} else {
			days = (int) ((t1 - t2) / (3600000 * 24)) + 1;
		}
		// int hours = (int) ((t1 - t2) / 3600000);
		// int minutes = (int) (((t1 - t2) / 1000 - hours * 3600) / 60);
		return days;
	}
	
	
	/**
     * 获取某月的所有天的集合
     * @param month yyyyMM
     * @return
     */
    public static List<Date> getDatesOfMonth(String month){
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
    	Date date=null;
		try {
			date = formatter.parse(month);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	Calendar calStart=Calendar.getInstance();
    	Calendar calEnd=Calendar.getInstance();
    	calStart.setTimeInMillis(date.getTime());
    	calEnd.setTimeInMillis(date.getTime());
    	calEnd.set(Calendar.MONTH,calStart.get(Calendar.MONTH)+1);
    	List<Date> results=new ArrayList<Date>();
    	
    	Date monthDate=calStart.getTime();
    	while(monthDate.getTime()<calEnd.getTimeInMillis()){
    		results.add(monthDate);
    		calStart.setTime(monthDate);
    		calStart.add(Calendar.DAY_OF_MONTH, 1);
    		monthDate=calStart.getTime();
    	}
    	return results;
    }
    
    /**
	 * 根据操作符判定是否对传入的时间进行修改
	 * @param requestDate 需要修改的日期
	 * @param modifyYear 年
	 * @param modifyMonth 月
	 * @param modifyDay 日
	 * @param para (操作符)0为减少，1为增加
	 * @return
	 */
	public static Date modifyDateTime(Date requestDate,int modifyYear,int modifyMonth,int modifyDay,int para){
				 	
		Calendar c = Calendar.getInstance();
		c.setTime(requestDate);
		
		//判定当前操作是增加还是减少
		if(para > 0){		
			
			//修改年份
			if(modifyYear > 0){
				c.add(Calendar.YEAR, modifyYear);
			}
			
			//修改月份
			if (modifyMonth > 0) {
				c.add(Calendar.MONTH,modifyMonth);
			}	
			
			//修改天数
			if (modifyDay > 0) {
				c.add(Calendar.DAY_OF_MONTH,modifyDay);
			}		
			
		//减少日期
		}else{
			//修改年份
			if(modifyYear > 0){
				c.add(Calendar.YEAR, -modifyYear);
			}
			
			//修改月份
			if (modifyMonth > 0) {
				c.add(Calendar.MONTH,-modifyMonth);
			}	
			
			//修改天数
			if (modifyDay > 0) {
				c.add(Calendar.DAY_OF_MONTH,-modifyDay);
			}			
		}
		
		return c.getTime();
	}
	
}
