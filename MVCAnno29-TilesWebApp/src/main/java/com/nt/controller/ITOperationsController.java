package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ITOperationsController {
	
	@RequestMapping("/home.htm")
	public  String showHomePage() {
		return "page1Def";
	}
	
	@RequestMapping("/courses.htm")
	public   String showCoursesPage() {
		return "page2Def";
	}
	
	@RequestMapping("/faculty.htm")
	public String showFacultyPage() {
		return "page3Def";
	}
	
	@RequestMapping("/address.htm")
	public String showAddressPage() {
		return "page4Def";
	}


}
