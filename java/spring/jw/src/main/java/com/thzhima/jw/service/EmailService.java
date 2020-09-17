package com.thzhima.jw.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender sender;
	
	public void sendMail(String from, String to,String subject, String content) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(from);
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(content);
		msg.setSentDate(new Date());
		this.sender.send(msg);
	}
	
	public void sendHtmlMail(String from, String to,String subject, String content) throws MessagingException {
		MimeMessage msg = this.sender.createMimeMessage();
		
		MimeMessageHelper help = new MimeMessageHelper(msg);
		
		help.setFrom(from);
		help.setTo(to);
		help.setSubject(subject);
		help.setText(content, true);
		help.setSentDate(new Date());
		this.sender.send(msg);
	}
}
