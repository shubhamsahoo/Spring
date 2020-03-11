package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan(basePackages = "com.nt.controller")
public class WebMVCAppConfig {
	
	@Bean
	public  CommonsMultipartResolver   createCMR() {
		CommonsMultipartResolver resolver=null;
		resolver=new CommonsMultipartResolver();
		return resolver;
	}

}
