package com.nt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishMessageService;

@Controller
public class WishMessageController {
	@Autowired
	 private WishMessageService service;
	
	/*@RequestMapping("/wish.htm")
	public  ModelAndView  process() {
		String msg=null;
		//use service 
		msg=service.generateWishMessage();
		return new ModelAndView("result", "wMsg",msg);
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  String  process(Model model) {
		String msg=null;
		//use service 
		msg=service.generateWishMessage();
		System.out.println(model.getClass());
		model.addAttribute("wMsg",msg);
		return "result";
	}*/
	
	@RequestMapping("/wish.htm")
	public  String  process(Map<String,Object> map) {
		String msg=null;
		//use service 
		msg=service.generateWishMessage();
		System.out.println(map.getClass());
		map.put("wMsg",msg);
		return "result";
	}
	
/*	@RequestMapping("/wish.htm")
	public  void  process(Map<String,Object> map) {
		String msg=null;
		//use service 
		msg=service.generateWishMessage();
		System.out.println(map.getClass());
		map.put("wMsg",msg);
	} */
	
	/*@RequestMapping("/wish.htm")
	public  Model  process() {
		String msg=null;
		Model model=null;
		//use service 
		msg=service.generateWishMessage();
		model=new  ExtendedModelMap();
		model.addAttribute("wMsg",msg);
		return model;
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  ModelMap  process() {
		String msg=null;
		ModelMap model=null;
		//use service 
		msg=service.generateWishMessage();
		model=new  ModelMap();
		model.addAttribute("wMsg",msg);
		return model;
	}*/
	
	/*@RequestMapping("/wish.htm")
		public  Map  process() {
			String msg=null;
			Map<String,Object> map=null;
			//use service 
			msg=service.generateWishMessage();
			map=new HashMap();
			map.put("wMsg",msg);
			return map;
		}
	*/
}
