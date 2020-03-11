package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMvcAppConfig;

public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		  AnnotationConfigWebApplicationContext parentCtx=null,childCtx=null;
		  ContextLoaderListener listener=null;
		  DispatcherServlet  servlet=null;
		  ServletRegistration.Dynamic dynamic=null;
		  
		  //create Parent IOC container
		  parentCtx=new AnnotationConfigWebApplicationContext();
		  parentCtx.register(RootAppConfig.class);
		  //create ContextLoaderListener having parentContainer and add ServletContainer
		  listener=new ContextLoaderListener(parentCtx);
		 sc.addListener(listener);
		 
		 //create child IOC container
		 childCtx=new AnnotationConfigWebApplicationContext();
		 childCtx.register(WebMvcAppConfig.class);
		 //create DispatcherServlet having childContainer and add to ServletContainer
		 servlet=new DispatcherServlet(childCtx);
		 dynamic=sc.addServlet("dispatcher",servlet);
		 dynamic.addMapping("*.htm");
		 dynamic.setLoadOnStartup(2);

	}

}
