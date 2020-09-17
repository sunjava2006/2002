package com.thzhima.jw.service;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailServiceTest {

	@Autowired
	private EmailService es;
	
	@Autowired
	private Logger logger;
	
//	@Test
	void testSendMail() {
		es.sendMail("392977758@qq.com", "jkwangrui@126.com", "test", "<a href=\"http://www.qq.com\">qq<a>");
	}
	
	@Test
	void testSendHtmlMail() throws MessagingException {
		logger.error("logger ..............test");
		es.sendHtmlMail("392977758@qq.com", "jkwangrui@126.com", "test", "<a href=\"http://www.qq.com\">qq</a>");
	}

}
