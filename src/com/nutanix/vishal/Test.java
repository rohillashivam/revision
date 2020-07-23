package com.nutanix.vishal;

import java.util.HashMap;
import java.util.Map;

public class Test {

	private static final String format = "dd-MM-yyyy mm:ss";
	
	private static final Map<Integer, Integer> monthDayMapping = new HashMap<>(); 
	static {
		monthDayMapping.put(1, 31);
		monthDayMapping.put(2, 28);
		monthDayMapping.put(4, 30);
	}
	public static void main(String[] args) {
		//"21-02-1999 23:20";
		// "01 02-1999 23:20";
	}
	
	private boolean validateDateString(String timeStamp) {
		if(timeStamp == null || timeStamp.isEmpty())
			return false;
		
		String[] dateTime = timeStamp.split(" ");
		if(dateTime.length != 2)
			return false;
		try {
		validateDateMonthYear(dateTime[0]);
		} catch(RuntimeException e) {
			return false;
		}
		
		return false;
	}

	private boolean validateDateMonthYear(String date) {
		
		String[] dateStr = date.split("-");
		if(dateStr.length != 3)
			return false;
		String day = dateStr[0];
		String month = dateStr[1];
		String yr = dateStr[2];
		
		if(day == null || day.isEmpty())
			return false;
		
		Integer dayInt = isNumber(day);
		Integer monthInt = isNumber(month);
		
		if(monthInt != 2 && monthDayMapping.containsKey(monthInt)) {
			int dayCount = monthDayMapping.get(monthInt);
			
		}
		
		return false;
	}

	private int isNumber(String num) {
		return Integer.parseInt(num);
	}
}
