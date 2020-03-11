package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.EmployeeSearchCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;
import com.nt.service.EmployeeService;

@Controller
public class EmployeeSearchController  {
	@Autowired
	private EmployeeService  service;
	
	@RequestMapping("/home.htm")
	public   String  showForm() {
		return "search_form";
	}
	

	@RequestMapping("/search.htm")
	public String search(Map<String,Object> map,@ModelAttribute EmployeeSearchCommand cmd		) throws Exception {
		EmployeeDTO dto=null;
		List<EmployeeResultDTO> listRDTO=null;
		//convert cmd to DTO
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use Service
		listRDTO=service.find(dto);
		//add results to  Map collection
		map.put("searchResults", listRDTO);
		//return MAV object
		return "report";
	}

}
