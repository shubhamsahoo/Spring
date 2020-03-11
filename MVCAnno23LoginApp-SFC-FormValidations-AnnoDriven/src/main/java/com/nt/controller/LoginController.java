package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	
	@RequestMapping(value="/login.htm",method = RequestMethod.GET)
	public  String  showForm(@ModelAttribute("userCmd") UserCommand cmd) {
		cmd.setUsername("raja");
		cmd.setPassword("rani");
		return "login_form";
	}
	
	@RequestMapping(value="/login.htm",method = RequestMethod.POST)
	public  String processForm(Map<String,Object> map, @Valid @ModelAttribute("userCmd") UserCommand cmd,BindingResult errors) {
		UserDTO dto=null;
		String result=null;
		if(errors.hasErrors())
			return "login_form";
		//convert Command to DTO class object
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use Service
		result=service.authenticate(dto);
		//put result map obj as mode Attrubute
		map.put("resultMsg",result);
		map.put("cmdData",cmd);
		return "login_form";
	}
	
	@ModelAttribute("countriesList")
	public  List<String>  populateCountries(){
		List<String>  countries=null;
		countries=new ArrayList();
		countries.add("india");
		countries.add("pakistan");
		countries.add("Italy");
		countries.add("china");
		countries.add("USA");
		return countries;
	}
	
	@ModelAttribute("hobiesList")
	public List<String>  populateHobies(){
		List<String> hobies=null;
		hobies=new ArrayList();
		hobies.add("sleeping");
		hobies.add("filtering");
		hobies.add("surfering");
		hobies.add("roaming");
		hobies.add("telling stories");
		return hobies;
	}
	
	@InitBinder
	public  void    myBinder(WebDataBinder binder) {
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf, true));
	}
	
	
}
