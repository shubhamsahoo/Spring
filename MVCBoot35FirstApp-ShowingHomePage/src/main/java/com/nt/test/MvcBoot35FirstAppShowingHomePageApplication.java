package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.WebMVCAppConfig;

@SpringBootApplication
@Import(WebMVCAppConfig.class)
public class MvcBoot35FirstAppShowingHomePageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcBoot35FirstAppShowingHomePageApplication.class, args);
	}

}
