package com.school.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry vcr) {
		vcr.addViewController("/").setViewName("home");
		vcr.addViewController("/addUser").setViewName("registration");
		vcr.addViewController("/login").setViewName("login");
	}

}
