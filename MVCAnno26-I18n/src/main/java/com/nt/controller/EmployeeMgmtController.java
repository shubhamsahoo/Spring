package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.EmployeeCommand;

@Controller
public class EmployeeMgmtController {
	
	@RequestMapping(value="/register.htm",method=RequestMethod.GET)
	public  String  showRegistrationPage(@ModelAttribute("empCmd")EmployeeCommand cmd) {
		return "emp_register_form";
	}

}
