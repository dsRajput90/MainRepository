package com.travolution.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {
	public static Date getCurrentMonthStartDate() {
		Calendar calendar = Calendar.getInstance();   // this takes current date
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	    return calendar.getTime();
	}

	public static Date getCurrentMonthEndDate() {
		Calendar calendar = Calendar.getInstance();   // this takes current date
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	    return calendar.getTime();
	}
	
	public static Long getDateDifferenceInDays(Date dateTo, Date dateFrom) {
		Long days = 0L;
		Calendar calTo = Calendar.getInstance();
		Calendar calFrom = Calendar.getInstance();
		if(dateFrom!= null) {
			calTo.setTime(dateTo);
			calFrom.setTime(dateFrom);  
			long diff = dateTo.getTime() - dateFrom.getTime();//as given
			days = TimeUnit.MILLISECONDS.toDays(diff);
		}  
		return days;
	}	


	public static int getDateDifferenceInYears(Date dateTo, Date dateFrom) {
		int years = 0;
		Calendar calTo = Calendar.getInstance();
		Calendar calFrom = Calendar.getInstance();
		if(dateFrom!= null) {
			calTo.setTime(dateTo);
			calFrom.setTime(dateFrom);  
			years = calTo.get(Calendar.YEAR) - calFrom.get(Calendar.YEAR);             
			if(calTo.get(Calendar.DAY_OF_YEAR) < calFrom.get(Calendar.DAY_OF_YEAR))  {
				years-=1;
			}
		}  
		return years;
	}

	public static String formatDate(Date date,String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);    	
	}
	/**
	 * Add number of days to current date
	 * @param days
	 * @return
	 */
	public static Date addDaysToCurrentDate(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	/**
	 * Add number of days to current date
	 * @param days
	 * @return
	 */
	public static Date addMonthToDate(int months,Date date) {
		Calendar calendar = Calendar.getInstance();
		if(date!=null){
			calendar .setTime(date);
		}		
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	public static Timestamp convetStringToTimestamp(String date, String time) {
		/**
		 * date format is DDMMYYYY and time format is HHMMSS.
		 * 
		 * Concert date to YYYY-MM-DD format and time to HH:MM:SS and concat to create timestamp string YYYY-MM-DD HH:MM:SS
		 * 
		 * Convert whole string into Timestamp object.
		 */
		StringBuilder itemDate = new StringBuilder(date.substring(4, 8)).append("-")
				.append(date.substring(2,4)).append("-")
				.append(date.substring(0,2)).append(" ")
				.append(time.substring(0,2)).append(":")
				.append(time.substring(2,4)).append(":")
				.append(time.substring(4,6));
		return Timestamp.valueOf(itemDate.toString());		
	}
	
	public static Timestamp convetStringToTimestamp(String date, SimpleDateFormat dateFormat ) {
	    Date parsedDate;
	    Timestamp timestamp = null;
		try {
			parsedDate = dateFormat.parse(date);
			 timestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	    return timestamp;
	}
	public static String getCurrentDate(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());    	
	}
	
}
