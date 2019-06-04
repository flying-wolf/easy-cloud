package com.superm.easy.cloud.commons.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SysDateTimeUtil {

	private static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat formatNoLine = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	private static SimpleDateFormat formatStart = new SimpleDateFormat(
			"yyyy-MM-dd 00:00:00");
	private static SimpleDateFormat formatEnd = new SimpleDateFormat(
			"yyyy-MM-dd 23:59:59");
	private static SimpleDateFormat formatDate = new SimpleDateFormat(
			"yyyy-MM-dd");

	/** 得到系统的当前时间年月日,时分秒,String类型 */
	public static String getCurrentSysDateTime() {
		return format.format(new Date());
	}

	/**
	 * 根据操作符判定是否对传入的时间进行修改
	 * 
	 * @param requestDate
	 *            需要修改的日期
	 * @param modifyYear
	 *            年
	 * @param modifyMonth
	 *            月
	 * @param modifyDay
	 *            日
	 * @param para
	 *            (操作符)0为减少，1为增加
	 * @return
	 */
	public static Date modifyYearAndMonth(Date requestDate, int modifyYear,
			int modifyMonth, int modifyDay, int para) {

		Calendar c = Calendar.getInstance();
		c.setTime(requestDate);
		// 判定当前操作是增加还是减少
		if (para > 0) {
			// 修改年份
			if (modifyYear > 0) {
				c.add(Calendar.YEAR, modifyYear);
			}
			// 修改月份
			if (modifyMonth > 0) {
				c.add(Calendar.MONTH, modifyMonth);
			}
			// 修改天数
			if (modifyDay > 0) {
				c.add(Calendar.DAY_OF_MONTH, modifyDay);
			}
			// 减少日期
		} else {
			// 修改年份
			if (modifyYear > 0) {
				c.add(Calendar.YEAR, -modifyYear);
			}
			// 修改月份
			if (modifyMonth > 0) {
				c.add(Calendar.MONTH, -modifyMonth);
			}
			// 修改天数
			if (modifyDay > 0) {
				c.add(Calendar.DAY_OF_MONTH, -modifyDay);
			}
		}
		return c.getTime();
	}

	public static String getCurrentSysDateTimeNoLine() {
		return formatNoLine.format(new Date());
	}

	/** 得到当天最早的时间 */
	public static String getCurrentSysDate1() {
		return formatStart.format(new Date());
	}

	/** 得到当天最晚的时间 */
	public static String getCurrentSysDate2() {
		return formatEnd.format(new Date());
	}

	/** 根据时间参数获取当天最早的时间 */
	public static String formatDatePioneer(Date date) {
		return formatStart.format(date);
	}

	/** 根据时间参数获取当天最晚的时间 */
	public static String formatDateNight(Date date) {
		return formatEnd.format(date);
	}

	public static String parseDate1(String date) {
		ParsePosition pos = new ParsePosition(0);
		return formatStart.format((formatDate.parse(date, pos))).toString();
	}

	public static String parseDate2(String date) {
		ParsePosition pos = new ParsePosition(0);
		return formatEnd.format((formatDate.parse(date, pos))).toString();
	}

	public static String getUniDate() {
		return formatDate.format(new Date());
	}

	public static String getToChineseDateMonth(String date) {
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		return year + "年" + month + "月";
	}

	/**
	 * 把字符串日期转换成24hh Date对象
	 * */
	public static Date toDate(String dateStr) {
		ParsePosition pos = new ParsePosition(0);
		return format.parse(dateStr, pos);
	}

	/**
	 * 把Date日期转换成字符串24hh小制的
	 * */
	public static String toStrDate(Date date) {
		return format.format(date);
	}

	/**
	 * 把Date日期转换成字符串，只有日期
	 * */
	public static String toStrOnlyDate(Date date) {
		if (date == null || "".equals(date)) {
			return "";
		} else {
			return formatDate.format(date);
		}
	}

	/**
	 * 根据两个日期,载取小数位位数 , 计时相隔的小时以60为进制的除法）;
	 * 
	 * @param date
	 *            --时间
	 * @param date2
	 *            -- 时间
	 * @param paraCount
	 *            载取小数位位数;
	 * */
	public static Float getComputerDateTime(Date date, Date date2, int paraCount) {
		double timeLong = Math.abs(date.getTime() - date2.getTime());
		Double dayHours = (Double) ((timeLong / 1000) / 3600);
		// System.out.println("你指定的两个时间点之间的天数是："+dayHours);
		// dayHours = Math.scalb(dayHours,2);//让计时加倍
		// System.out.println("你指定的两个时间点之间的天数是："+dayHours);
		// 经确的位数
		// int rountCount = 2;
		// 处理成两位小数
		String strDayHours = dayHours.toString();
		// 点的下标位置
		int point_posi = strDayHours.indexOf(".");
		// 小数点以后的位数
		int point_length = 0;
		if (point_posi > 0) {
			point_length = strDayHours.substring(point_posi + 1,
					strDayHours.length()).length();
		}
		// 处理后的小时数字符串(只有两位小数)
		String processAfetrHours = "";
		if (point_length >= 2) {
			processAfetrHours = strDayHours.substring(0, point_posi + paraCount
					+ 1);
		} else {
			;
		}
		Float processAfterDayHours = Float.parseFloat(processAfetrHours);
		return processAfterDayHours;
	}

	/**
	 * 计算两个日期相差的天数 永远返回非0整数
	 * */
	public static int getMiddDayByTwoDate(Date date1, Date date2) {
		Calendar lastCalendar = Calendar.getInstance();
		if (date1 == null || date2 == null) {
			return -1;
		}

		// 得到第一个日期的年月日。
		lastCalendar.setTime(date1);
		int oneYear = lastCalendar.get(Calendar.YEAR);
		int oneMonth = lastCalendar.get(Calendar.MONTH);
		int oneDay = lastCalendar.get(Calendar.DATE);

		// 得到第二个日期的年月日。
		lastCalendar.setTime(date2);
		int twoYear = lastCalendar.get(Calendar.YEAR);
		int twoMonth = lastCalendar.get(Calendar.MONTH);
		int twoDay = lastCalendar.get(Calendar.DATE);

		// 计算相差的天数
		int yearCountDay = (oneYear - twoYear) * 365;
		int monthCountDay = (oneMonth - twoMonth) * 30;
		int dayCountDay = oneDay - twoDay;

		return Math.abs(yearCountDay + monthCountDay + dayCountDay);
	}

	/**
	 * 得到提前某天的日期
	 * 
	 * @param i
	 * @return
	 */
	public static String advanceDate(int i) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - i);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(c.getTime());
		return date;
	}

	public static void main(String[] args) {
		// System.out.println(getCurrentSysDateTime());
		// System.out.println(getCurrentSysDate1());
		// System.out.println(getCurrentSysDate2());
		//
		// System.out.println(parseDate1("2010-07-19"));
		// System.out.println(parseDate2("2010-02-23"));
		//
		// System.out.println(toDate("2011-08-11 15:23:59"));
		// System.out.println(toStrDate(toDate("2011-08-11 15:23:59")));
		// System.out.println(getToChineseDateMonth("2010-02"));;
		// getComputerDateTime(toDate("2011-08-11 08:23:12"),toDate("2011-08-11 08:23:59"),2);
		// System.out.println(toStrOnlyDate(new Date()));
		// Long j=null;
		// System.out.println(j);
		//
		// try {
		// System.out.println(URLDecoder.decode("%3A%2F%2F","gbk"));
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		// String s = sf.format(modifyYearAndMonth(new Date(),5,5,5,0));
		// System.out.println(s);

		// System.out.println("测试两个日期相差的天数:"+getMiddDayByTwoDate(toDate("2011-08-11 08:23:12"),
		// toDate("2012-09-12 08:23:12")));

		String tt = "20121024145330";
		SimpleDateFormat sdf32 = new SimpleDateFormat("yyyyMMddHHmmss");

		try {
			System.out.print("data:" + sdf32.parse(tt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
