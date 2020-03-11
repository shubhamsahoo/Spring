package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishMessageService;

@Controller
public class WishMessageController {
	@Autowired
	private WishMessageService service;
	
	@RequestMapping("/wish.htm")
	public  String  wishMessage(Map<String,Object> map) {
		String result=null;
		//use service
		result=service.generateWishMessage();
		//place result as model data.
		map.put("resultMsg",result);
		return "result";
		
	}

}
