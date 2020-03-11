package org.ar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ar.service.WishGeneratorService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishController extends AbstractController{
   private WishGeneratorService service;
   
	public WishController(WishGeneratorService service) {
	super();
	this.service = service;
}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub\
		String wish=null;
		wish=service.generateWish();
		
		return new ModelAndView("result", "wishMessage",wish);
	}

}
