package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;
import com.nt.validator.LoginValidator;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	@Autowired
	private LoginValidator  validator;
	
	@RequestMapping(value="/login.htm",method = RequestMethod.GET)
	public  String  showForm(@ModelAttribute("userCmd") UserCommand cmd) {
		cmd.setUsername("raja");
		cmd.setPassword("rani");
		return "login_form";
	}
	
	@RequestMapping(value="/login.htm",method = RequestMethod.POST)
	public  String processForm(Map<String,Object> map,
			                                           @ModelAttribute("userCmd") UserCommand cmd,
			                                           BindingResult errors) {
			                                             
		UserDTO dto=null;
		String result=null;
		//perform Validations
		  if(validator.supports(UserCommand.class)) {
			       validator.validate(cmd, errors);
			       if(errors.hasErrors())
			    	     return "login_form";
		  }
		//convert Command to DTO class object
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use Service
		result=service.authenticate(dto);
		//put result map obj as mode Attrubute
		map.put("resultMsg",result);
		return "login_form";
	}
	
	
}
