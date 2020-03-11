package org.ar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ar.dto.EmployeeDTO;
import org.ar.service.EmployeeService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class EmployeeDetailsController extends AbstractController{
   private EmployeeService service;
   
	public EmployeeDetailsController(EmployeeService service) {
	super();
	this.service = service;
}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<EmployeeDTO> dto=null;
		dto=service.getDetails();
		return new ModelAndView("empDetails","listDTO",dto);
	}
 
	
}
