package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements WishMessageService {
	

	@Override
	public String generateWishMessage() {
		Calendar calendar=null;
		int hour=0;
		String msg=null;
		//get System date
		calendar=Calendar.getInstance();
		//get hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate wish Message
		if(hour<8)
		  throw new IllegalArgumentException("invalid time to distrub");
		else if(hour<12)
			msg="Good Morning";
		else  if(hour<16)
			msg="Good AfterNoon";
		else if(hour<20)
			msg="Good Evening";
		else
			msg="Good Night";
		return msg;
	}

}
