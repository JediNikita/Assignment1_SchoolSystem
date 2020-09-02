package com.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfig {
	
	 	@Bean
	    public InternalResourceViewResolver viewResolver() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("WEB-INF/");     
	    resolver.setSuffix(".jsp");
	    //resolver.setExposeContextBeansAsAttributes(true);
	    resolver.setViewClass(JstlView.class);
	    return resolver;
	    }
}
