package com.thzhima.jw.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	
	@Bean
	public Logger getLogger() {
		Logger logger =LoggerFactory.getLogger(MyConfig.class);
        return logger;

	}
}
