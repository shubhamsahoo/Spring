package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.HotelDTO;

public class ReportGenerationController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		HotelDTO  dto1=null,dto2=null,dto3=null;
		List<HotelDTO>  listDTO=null;
		
		dto1=new HotelDTO();
		
		dto1.setHotelId(90001);
		dto1.setHotelName("Trident");
		dto1.setHotelType("5 -star");
		dto1.setLocation("HitechCity-Hyd");
		dto1.setSize(200);
		dto1.setPriceRange("50000-1000000");
		
		dto2=new HotelDTO();
		dto2.setHotelId(80001);
		dto2.setHotelName("Taj");
		dto2.setHotelType("5 -star");
		dto2.setLocation("Banjarhills-Hyd");
		dto2.setSize(200);
		dto2.setPriceRange("50000-100000");
		
		dto3=new HotelDTO();
		dto3.setHotelId(50001);
		dto3.setHotelName("Golden Heavn");
		dto3.setHotelType("5 -star");
		dto3.setLocation("DamDam-Kolcutta");
		dto3.setSize(100);
		dto3.setPriceRange("5000-10000");
		
		listDTO=new ArrayList();
		listDTO.add(dto1); listDTO.add(dto2); listDTO.add(dto3);
		
		if(req.getParameter("type").equalsIgnoreCase("pdf"))
			return new ModelAndView("pdfView","hotelsDTO",listDTO);
		else
			return new ModelAndView("excelView","hotelsDTO",listDTO);
	}//method
}//class
