package com.thzhima.jw;

import org.apache.log4j.Logger;

public class LogTest {


	public static void a(int b) {
		Logger logger = Logger.getLogger(LogTest.class);
		try {
			int a = 90;
			
			if(logger.isInfoEnabled()) {
				logger.info(b);
			}
			int c = a/b;
		} catch (Exception e) {
			logger.error(e);
		}
		
	}
	
	public static void main(String[] args) {
		a(0);
	}
}
