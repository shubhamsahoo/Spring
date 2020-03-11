package org.ar.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMessage1Controller extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub\
		Calendar cal=null;
		int hour=0;
		String msg=null;
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
		return new ModelAndView("result2", "wishMessage",msg);
	}

}
