package org.tutev.cagri.web.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sabit {

	public static String dateFormatDDMMYYYY="ddMMyyyy";
	
	public static String dateToStringDDMMYYY(Date d) {
		SimpleDateFormat sdf=new SimpleDateFormat(dateFormatDDMMYYYY);
		return sdf.format(d);
	}
	
	
	public static Date stringToDateDDMMYYY(String s) {
		Date date = null;
		SimpleDateFormat dt = new SimpleDateFormat(dateFormatDDMMYYYY); 
		try {
			date = dt.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return date;
	}
}
