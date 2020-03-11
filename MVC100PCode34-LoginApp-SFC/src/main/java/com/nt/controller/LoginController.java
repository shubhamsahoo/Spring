package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginMgmtService;

@Controller
public class LoginController {
	@Autowired
	private LoginMgmtService  service;
	
	
	//@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	@GetMapping("/login.htm")
	public  String  showForm(@ModelAttribute("userCmd") UserCommand cmd) {
		return "login_form";
	}
	
	//@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	@PostMapping("/login.htm")
	public  String  processForm(Map<String,Object> map,
			@ModelAttribute("userCmd") UserCommand cmd) {
		UserDTO dto=null;
		String result=null;
		//convert Comand to DTO	
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use Service
		result=service.authenticate(dto);
		//put reuslt model Attribute
		map.put("resultMsg",result);
		return "login_form";
		
		
	}

}
