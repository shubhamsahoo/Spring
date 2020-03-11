package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebAppInitializer implements WebApplicationInitializer {
	 static {
		 System.out.println("MyWebAppInitializer.static block()");
	 }
	 public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer:: 0-param constructor");
	}

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		System.out.println("MyWebAppInitializer.onStartup(-)");
	   AnnotationConfigWebApplicationContext rootCtx=null,childCtx=null;
	   ContextLoaderListener listener=null;
	   DispatcherServlet  servlet=null;
	   ServletRegistration.Dynamic dyna=null;
	   //create Parent Contianer
	   rootCtx=new AnnotationConfigWebApplicationContext();
	   rootCtx.register(RootAppConfig.class);
	   //create ContextLoader having ParentContainer and register with ServletContainer dynamically
	   listener=new ContextLoaderListener(rootCtx);
	   sc.addListener(listener);
	   
	   //create Child Container
	   childCtx=new AnnotationConfigWebApplicationContext();
	   childCtx.register(WebMVCAppConfig.class);
	   //create DispatcherServlet obj having child Container and register with ServletContainer
	   servlet=new DispatcherServlet(childCtx);
	   dyna=sc.addServlet("dispatcher",servlet);
	   dyna.addMapping("*.htm");
	   dyna.setLoadOnStartup(2);
	}

}
