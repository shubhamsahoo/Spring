package com.nt.interceptor;

import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class DoublePostingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
	  HttpSession ses=null;	
	  int clientToken=0;
	  int serverToken=0;
	  RequestDispatcher rd=null;
	  
	  //create HttpSession object
	  ses=req.getSession();
	  //for InitialPhase request
	  if(req.getMethod().equalsIgnoreCase("GET")) {
		  //create ServerSide Token
		  ses.setAttribute("sToken", new Random().nextInt(1000));
		  return true;
	  }
	  else {
		  //read  server Side token and client side Toklen values
		  clientToken=Integer.parseInt(req.getParameter("cToken"));
		  serverToken=(Integer)ses.getAttribute("sToken");
		  if(clientToken==serverToken) {
			  //change server side Token Value
			  ses.setAttribute("sToken",new Random().nextInt(1000));
			  return true;
		  }
		  else {
			  rd=req.getRequestDispatcher("/dbl_post.jsp");
			  rd.forward(req,res);
			  return false;
		  }
	  }//else
	  
	
	}//preHAndle
}//class
