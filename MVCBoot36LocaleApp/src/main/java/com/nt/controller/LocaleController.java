package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.LocaleService;

@Controller
public class LocaleController {
	@Autowired
	private LocaleService service;
	
	@RequestMapping("/home.htm")
	public String showHomePage() {
		return "welcome";
	}
	
	@RequestMapping("/langs.htm")
	public String  showLanguages(Map<String,Object>  map) {
		List<String> langList=null;
 		//use Service class
		langList=service.getAllLanguages();
		//put result is mode attrobute
		map.put("operation","languages");
		map.put("resultList",langList);
		return "result";
	}
	
	@RequestMapping("/countries.htm")
	public String  showCountries(Map<String,Object>  map) {
		List<String> countriesList=null;
 		//use Service class
		countriesList=service.getAllCountries();
		//put result is mode attrobute
		map.put("operation","countries");
		map.put("resultList",countriesList);
		return "result";
	}

}
