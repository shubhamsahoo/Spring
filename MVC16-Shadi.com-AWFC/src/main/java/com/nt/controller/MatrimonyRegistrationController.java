package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.nt.command.RegisterCommand;

public class MatrimonyRegistrationController extends AbstractWizardFormController {

	@Override
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		RegisterCommand cmd=null;
		//type casting
		cmd=(RegisterCommand)command;
		System.out.println("MatrimonyRegistrationController.processFinish(-,-)");
		
		return new ModelAndView("result", "cmdData", cmd);
	}
	
	@Override
	protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println("MatrimonyRegistrationController.processCancel(-,-)");
		return new ModelAndView("welcome");
		
	}
	
	@Override
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		System.out.println("MatrimonyRegistrationController.initBinder(-,-)");
		  SimpleDateFormat sdf1=null;
		  sdf1=new SimpleDateFormat("dd-MM-yyyy");
		  binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf1,true));
	}
	
	@Override
	public Map referenceData(HttpServletRequest request, int page) throws Exception {
		System.out.println("MatrimonyRegistrationController.referenceData(-,-)");
		         Map<String,List<String>> map=null;
		         List<String> genders=null;
		         List<String> hobies=null;
		         
		         genders=new ArrayList();
		         genders.add("Male"); genders.add("Female");
		         
		         hobies=new ArrayList();
		         hobies.add("shopping"); hobies.add("sleeping");
		         hobies.add("eating"); hobies.add("traveling");
		         
		         map=new HashMap();
		         map.put("gendersList",genders );
		         map.put("hobiesList", hobies);
		         return map;
	}

}
