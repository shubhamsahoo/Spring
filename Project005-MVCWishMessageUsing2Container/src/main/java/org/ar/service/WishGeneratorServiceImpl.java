package org.ar.service;

import java.util.Calendar;

public class WishGeneratorServiceImpl implements WishGeneratorService{

	public String generateWish() {
		String msg=null;
		Calendar cal=null;
		int hour=0;
		
		cal=Calendar.getInstance();
		hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<5)
			msg="good night";
		else if(hour<=12)
			msg="GM";
		else if(hour<=16)
			msg="GA";
		else if(hour<=20)
			msg="GE";
		else
			msg="GN";
		return msg;
	}
	

}
