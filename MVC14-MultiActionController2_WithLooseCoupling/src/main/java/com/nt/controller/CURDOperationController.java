package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.nt.command.UserCommand;

public class CURDOperationController extends MultiActionController {
	
	public    ModelAndView  add(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		System.out.println("CURDOperationController.add(-,-,-)");
	  ModelAndView  mav=null;
		mav=new ModelAndView();
		mav.addObject("cmdData",cmd);
		mav.addObject("operation","add");
		mav.setViewName("user_form");
		return mav;
	}
	
	public    ModelAndView  update(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		System.out.println("CURDOperationController.update(-,-,-)");
	  ModelAndView  mav=null;
		mav=new ModelAndView();
		mav.addObject("cmdData",cmd);
		mav.addObject("operation","update");
		mav.setViewName("user_form");
		return mav;
	}
	
	public    ModelAndView  delete(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		System.out.println("CURDOperationController.delete(-,-,-)");
	  ModelAndView  mav=null;
		mav=new ModelAndView();
		mav.addObject("cmdData",cmd);
		mav.addObject("operation","delete");
		mav.setViewName("user_form");
		return mav;
	}
	
	public    ModelAndView  view(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		System.out.println("CURDOperationController.view(-,-,-)");
	  ModelAndView  mav=null;
		mav=new ModelAndView();
		mav.addObject("cmdData",cmd);
		mav.addObject("operation","view");
		mav.setViewName("user_form");
		return mav;
	}
	
	
	public    ModelAndView  invalid(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		System.out.println("CURDOperationController.invalid(-,-,-)");
	  ModelAndView  mav=null;
		mav=new ModelAndView();
		mav.addObject("cmdData",cmd);
		mav.addObject("operation","invalid");
		mav.setViewName("user_form");
		return mav;
	}
	
	
	
	   
	

}
