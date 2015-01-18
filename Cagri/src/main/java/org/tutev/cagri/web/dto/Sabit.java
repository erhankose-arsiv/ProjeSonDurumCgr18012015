package org.tutev.cagri.web.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Sabit {

	public static String dateFormatDDMMYYYY="ddMMyyyy";
	public String serviceAdress;
	
	
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
	
	public String getServiceAdress() {
		return serviceAdress;
	}
	public void setServiceAdress(String serviceAdress) {
		this.serviceAdress = serviceAdress;
	}
}
