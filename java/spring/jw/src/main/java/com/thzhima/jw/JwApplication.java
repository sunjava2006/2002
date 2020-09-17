package com.thzhima.jw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.thzhima.jw.configurations.MyMVCConfig;


@EnableTransactionManagement
@SpringBootApplication
public class JwApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(JwApplication.class, args);
		
	}

}
