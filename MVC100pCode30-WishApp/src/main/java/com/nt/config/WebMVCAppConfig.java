package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nt.controller")
public class WebMVCAppConfig {
	
	public WebMVCAppConfig() {
		System.out.println("WebMVCAppConfig.0-param constructor");
	}
	
	
	
	
	
	@Bean
	public   HandlerMapping  createSUHM() {
		System.out.println("WebMVCAppConfig.createSUHM()");
		SimpleUrlHandlerMapping  mapping=null;
		Properties props=null;
		mapping=new SimpleUrlHandlerMapping(); 
		props=new Properties();
		props.put("/home.htm","pvc");
		mapping.setMappings(props);
		//mapping.setOrder(Integer.MAX_VALUE-1);
		return mapping;
	}
	
	
	
	@Bean(name="pvc")
	public   ParameterizableViewController  createPVC() {
		System.out.println("WebMVCAppConfig.createPVC()");
		ParameterizableViewController pvc=null;
		pvc=new ParameterizableViewController();
		pvc.setViewName("welcome");
		return pvc;
		
	}
	
	@Bean
	public   ViewResolver createIRVR() {
		System.out.println("WebMVCAppConfig.createIRVR()");
		InternalResourceViewResolver  resolver=null;
		resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
		
	}
	
	

}
