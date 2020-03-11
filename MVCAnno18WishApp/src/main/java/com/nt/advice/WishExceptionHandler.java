package com.nt.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(annotations = Controller.class)
public class WishExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView  anyProblemHandler(Exception ex) {
		ModelAndView mav=null;
		mav=new ModelAndView();
		mav.addObject("errMsg",ex.getMessage());
		mav.setViewName("error_page");
		return mav;
	}

}
