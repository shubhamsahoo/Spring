package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

@Controller
public class ListEmployeesController {
	@Autowired
	private  EmployeeService service;
	
	
	@RequestMapping("/home.htm")
	public   String showHomePage() {
	   return "welcome";	
	}
	
	@RequestMapping("/list_emps.htm")
	public    String   searchEmps(Map<String,Object> map) {
		List<EmployeeDTO> listDTO=null;
		//use Service
		listDTO=service.fetchAllEmployees();
		//put result into model attribute
		map.put("emp_list",listDTO);
		return "show_emps";
	}

}
