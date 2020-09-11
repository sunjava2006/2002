package com.thzhima.jw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
public class JwApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwApplication.class, args);
	}

}
