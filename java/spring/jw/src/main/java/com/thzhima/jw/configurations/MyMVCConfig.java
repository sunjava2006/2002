package com.thzhima.jw.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.thzhima.jw.intercepters.AutoLoginIntercepter;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer{

	
	@Autowired
	private AutoLoginIntercepter auto;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("------------MyMVCConfig-------------------");
		
		registry.addInterceptor(auto).addPathPatterns("/*");
		
	}
	
	
}
