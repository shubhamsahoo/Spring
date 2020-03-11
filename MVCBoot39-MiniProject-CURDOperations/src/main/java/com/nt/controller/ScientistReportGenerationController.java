package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.ScientistCommand;
import com.nt.dto.ScientistDTO;
import com.nt.service.ScientistMgmtService;

@Controller
public class ScientistReportGenerationController  {
	@Autowired
	private  ScientistMgmtService service;

	@RequestMapping("/home.htm")
	public    String showHome() {
		return "welcome";
	}
	

	@RequestMapping("/report.htm")
	public String showReport(Map<String,Object> map)
			throws Exception {
		List<ScientistDTO> listDTO=null;
		ModelAndView mav=null;
		// user Service
		listDTO=service.fetchAllScientists();
		map.put("listDTO",listDTO);
		//return MAV object
		return "report";
	}
	
	@RequestMapping(value="/edit.htm",method = RequestMethod.GET)
	public  String   showEditForm(HttpServletRequest req,@ModelAttribute("scCmd")ScientistCommand cmd) {
		ScientistDTO dto=null;
		//use service
		dto=service.fetchScientistById(Integer.parseInt(req.getParameter("id")));
		//copy dto to cmd 
		BeanUtils.copyProperties(dto,cmd);
		return "edit_scientist";
	}
	
	
	@RequestMapping(value="/edit.htm",method = RequestMethod.POST)
	public String processEditForm(Map<String,Object> map,@ModelAttribute("scCmd") ScientistCommand cmd,
			BindingResult errors) throws Exception {
		ScientistDTO  dto=null;
		String resultMsg=null;
		List<ScientistDTO>  listDTO=null;
			//convert Command class obj to DTO
		dto=new  ScientistDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		resultMsg=service.modifyScientistById(dto);
		listDTO=service.fetchAllScientists();
		//return MAV object
		map.put("resultMsg", resultMsg);
		map.put("listDTO",listDTO);
		return "report";
	}

	
	
	@RequestMapping(value="/delete.htm")
	public String deleteScientist(HttpServletRequest req,Map<String,Object> map) {
		int id=0;
		String resultMsg=null;
		List<ScientistDTO>  listDTO=null;
		 //read additional req param value
		id=Integer.parseInt(req.getParameter("id"));
		//use service
		resultMsg=service.removeScientistById(id);
		listDTO=service.fetchAllScientists();
		//create and return MAV object
		map.put("resultMsg",resultMsg);
		map.put("listDTO", listDTO);
		return "report";
	}
	
	


}
