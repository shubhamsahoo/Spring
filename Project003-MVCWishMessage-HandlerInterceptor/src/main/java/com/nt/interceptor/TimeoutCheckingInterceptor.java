package com.nt.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeoutCheckingInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		System.out.println("TimeoutCheckingInterceptor.preHandle()");
		Calendar calendar=null;
		RequestDispatcher rd=null;
		int hour=0;
		//get System date and time
		calendar=Calendar.getInstance();
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		if(hour<9  || hour>=17) {
			rd=req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req,res);
			return false;
		}
		else {
			return true;
		}
   }//method
}//class
