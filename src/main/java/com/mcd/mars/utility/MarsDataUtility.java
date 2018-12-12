package com.mcd.mars.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MarsDataUtility {
	public final static String DATE_PATTERN = "MM-dd-yyyy";
	
	public static Date getAsDate(String dateStr) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
		return simpleDateFormat.parse(dateStr);
	}
}
