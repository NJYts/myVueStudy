package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DateUtil {
	public static String ymdhms = "yyyy-MM-dd HH:mm:ss";
	public static String ymd = "yyyy-MM-dd";
	public static SimpleDateFormat ymdSDF = new SimpleDateFormat(ymd);
	public static String year = "yyyy";
	public static String month = "MM";
	public static String day = "dd";
	public static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(ymdhms);
	public static SimpleDateFormat yearSDF = new SimpleDateFormat(year);
	public static SimpleDateFormat monthSDF = new SimpleDateFormat(month);
	public static SimpleDateFormat daySDF = new SimpleDateFormat(day);

	public static SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");

	public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat MMddHHmm = new SimpleDateFormat("MM-dd HH:mm");

	public static SimpleDateFormat yyyyMMddHH_NOT_ = new SimpleDateFormat(
			"yyyyMMdd");

	public static long DATEMM = 86400L;

	public static String getCurrentTime() {
		return yyyyMMddHHmmss.format(new Date());
	}

	public static String getYesterdayYYYYMMDD() {
		Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
		String str = yyyyMMdd.format(date);
		try {
			date = yyyyMMddHHmmss.parse(str + " 00:00:00");
			return yyyyMMdd.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getCurrentYear() {
		return yearSDF.format(new Date());
	}

	public static String getCurrentMonth() {
		return monthSDF.format(new Date());
	}

	public static String getCurrentDay() {
		return daySDF.format(new Date());
	}

	public static String getCurrentymd() {
		return ymdSDF.format(new Date());
	}

	public static long getTimeNumberToday() {
		Date date = new Date();
		String str = yyyyMMdd.format(date);
		try {
			date = yyyyMMdd.parse(str);
			return date.getTime() / 1000L;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0L;
	}

	public static String getTodateString() {
		Date date = new Date(System.currentTimeMillis());
		String str = yyyyMMddHH_NOT_.format(date);

		return str;
	}

	public static String getString(Date date) {
		String str = yyyyMMddHHmmss.format(date);

		return str;
	}

	public static String getYesterdayString() {
		Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
		String str = yyyyMMddHH_NOT_.format(date);

		return str;
	}

	/**
	 * 获得昨天零点
	 * 
	 * @return
	 */
	public static Date getYesterDayZeroHour() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		return cal.getTime();
	}

	/**
	 * 把long型日期转String ；---OK
	 * 
	 * @param date
	 *            long型日期；
	 * @param format
	 *            日期格式；
	 * @return
	 */
	public static String longToString(long date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		java.util.Date dt2 = new Date(date * 1000L);
		String sDateTime = sdf.format(dt2); // 得到精确到秒的表示：08/31/2006 21:08:00
		return sDateTime;
	}

	/**
	 * 获得今天零点
	 * 
	 * @return
	 */
	public static Date getTodayZeroHour() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		return cal.getTime();
	}

	/**
	 * 获得昨天23时59分59秒
	 * 
	 * @return
	 */
	public static Date getYesterDay24Hour() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.HOUR, 23);
		return cal.getTime();
	}

	/**
	 * String To Date ---OK
	 * 
	 * @param date
	 *            待转换的字符串型日期；
	 * @param format
	 *            转化的日期格式
	 * @return 返回该字符串的日期型数据；
	 */
	public static Date stringToDate(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获得指定日期所在的自然周的第一天，即周日
	 * 
	 * @param date
	 *            日期
	 * @return 自然周的第一天
	 */
	public static Date getStartDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, 1);
		date = c.getTime();
		return date;
	}

	/**
	 * 获得指定日期所在的自然周的最后一天，即周六
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, 7);
		date = c.getTime();
		return date;
	}

	/**
	 * 获得指定日期所在当月第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		date = c.getTime();
		return date;
	}

	/**
	 * 获得指定日期所在当月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DATE, -1);
		date = c.getTime();
		return date;
	}

	/**
	 * 获得指定日期的下一个月的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartDayOfNextMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		date = c.getTime();
		return date;
	}

	/**
	 * 获得指定日期的下一个月的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfNextMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONTH, 2);
		c.add(Calendar.DATE, -1);
		date = c.getTime();
		return date;
	}

	/**
	 * 
	 * 求某一个时间向前多少秒的时间(currentTimeToBefer)---OK
	 * 
	 * @param givedTime
	 *            给定的时间
	 * @param interval
	 *            间隔时间的毫秒数；计算方式 ：n(天)*24(小时)*60(分钟)*60(秒)(类型)
	 * @param format_Date_Sign
	 *            输出日期的格式；如yyyy-MM-dd、yyyyMMdd等；
	 */
	public static String givedTimeToBefer(String givedTime, long interval,
			String format_Date_Sign) {
		String tomorrow = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format_Date_Sign);
			Date gDate = sdf.parse(givedTime);
			long current = gDate.getTime(); // 将Calendar表示的时间转换成毫秒
			long beforeOrAfter = current - interval * 1000L; // 将Calendar表示的时间转换成毫秒
			Date date = new Date(beforeOrAfter); // 用timeTwo作参数构造date2
			tomorrow = new SimpleDateFormat(format_Date_Sign).format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tomorrow;
	}

	/**
	 * 把String 日期转换成long型日期；---OK
	 * 
	 * @param date
	 *            String 型日期；
	 * @param format
	 *            日期格式；
	 * @return
	 */
	public static long stringToLong(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dt2 = null;
		long lTime = 0;
		try {
			dt2 = sdf.parse(date);
			// 继续转换得到秒数的long型
			lTime = dt2.getTime() / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return lTime;
	}
	/***
	 * 
	 * @param date   
	 * 			String 
	 * @return 传输时间的前一天时间
	 */
	public static String getYesterday(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt2 = null;
		Date date2 =null;
		try {
			dt2 = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dt2);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			date2 = calendar.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return yyyyMMdd.format(date2);
	}
	/**
	 * 得到二个日期间的间隔日期；
	 * 
	 * @param endTime
	 *            结束时间
	 * @param beginTime
	 *            开始时间
	 * @param isEndTime
	 *            是否包含结束日期；
	 * @return
	 */
	public static Map<String, String> getTwoDay(String endTime,
			String beginTime, boolean isEndTime) {
		Map<String, String> result = new HashMap<String, String>();
		if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime
				.equals(""))))
			return null;
		try {
			java.util.Date date = ymdSDF.parse(endTime);
			endTime = ymdSDF.format(date);
			java.util.Date mydate = ymdSDF.parse(beginTime);
			long day = (date.getTime() - mydate.getTime())
					/ (24 * 60 * 60 * 1000);
			result = getDate(endTime, Integer.parseInt(day + ""), isEndTime);
		} catch (Exception e) {
		}
		return result;
	}
	public static Date getDateByString(String dataTime){
		Date date=new Date();
		 try {
				if(dataTime.trim().length()==19){
					 date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataTime);
				 }else if(dataTime.trim().length()==16){
					 date=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dataTime);
				 }else if(dataTime.trim().length()>=8){
					 date=new SimpleDateFormat("yyyy-MM-dd").parse(dataTime);
				 }else if(dataTime.trim().length()>=6){
					 date=new SimpleDateFormat("yyyy-MM").parse(dataTime);
				 }
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			return date;
	}
	/**
	 * 得到二个日期间的间隔日期；
	 * 
	 * @param endTime
	 *            结束时间
	 * @param beginTime
	 *            开始时间
	 * @param isEndTime
	 *            是否包含结束日期；
	 * @return
	 */
	public static Integer getTwoDayInterval(String endTime, String beginTime,
			boolean isEndTime) {
		if ((endTime == null || endTime.equals("") || (beginTime == null || beginTime
				.equals(""))))
			return 0;
		long day = 0l;
		try {
			java.util.Date date = ymdSDF.parse(endTime);
			endTime = ymdSDF.format(date);
			java.util.Date mydate = ymdSDF.parse(beginTime);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return 0 ;
		}
		return Integer.parseInt(day + "");
	}

	/**
	 * 根据结束时间以及间隔差值，求符合要求的日期集合；
	 * 
	 * @param endTime
	 * @param interval
	 * @param isEndTime
	 * @return
	 */
	public static Map<String, String> getDate(String endTime, Integer interval,
			boolean isEndTime) {
		Map<String, String> result = new HashMap<String, String>();
		if (interval == 0 || isEndTime) {
			if (isEndTime)
				result.put(endTime, endTime);
		}
		if (interval > 0) {
			int begin = 0;
			for (int i = begin; i < interval; i++) {
				endTime = givedTimeToBefer(endTime, DATEMM, ymd);
				result.put(endTime, endTime);
			}
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	/*public static String getFirstDate(String endTime, int intervalTime) {
		Map<String, String> result = DateUtil.getDate(endTime, intervalTime,
				true);
		result = ElintUtil.sortByValue(result, true);
		Set<String> keySet = result.keySet();
		Iterator<String> it = keySet.iterator();
		return it.next();
	}*/
	public static void main(String[] a) { }
}
