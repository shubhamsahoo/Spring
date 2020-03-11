package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

@Controller
@SessionAttributes(names = "userCmd")
public class LoginController {
	@Autowired
	private LoginService service;

	
	/*@RequestMapping(value="/login.htm",method = RequestMethod.GET)
	public  String  showForm(@ModelAttribute("userCmd") UserCommand cmd) {
		cmd.setUsername("raja");
		cmd.setPassword("rani");
		return "login_form";
	}*/
	
		@RequestMapping(value="/login.htm",method = RequestMethod.GET)
		public  String  showForm(Map<String,Object> map) {
			UserCommand cmd=new UserCommand();
			map.put("userCmd",cmd);		
			return "login_form";
		}
	
	@RequestMapping(value="/login.htm",method = RequestMethod.POST)
	public  String processForm(Map<String,Object> map, @ModelAttribute("userCmd") UserCommand cmd) {
		UserDTO dto=null;
		String result=null;
		//convert Command to DTO class object
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use Service
		result=service.authenticate(dto);
		//put result map obj as mode Attrubute
		map.put("resultMsg",result);
		return "result";
	}
	
	
}
