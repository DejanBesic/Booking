package com.booking.app.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MailSender {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Async
	public void sendMail(String to, String content, String subject) {
		Properties properties = new Properties();
		
	    properties.setProperty("mail.transport.protocol", "smtp");
	    properties.setProperty("mail.smtp.auth", "true");
	    properties.setProperty("mail.smtp.starttls.enable", "true");
	    properties.setProperty("mail.debug", "false");
	    properties.setProperty("mail.username", "sdmrbg123@gmail.com");
	    properties.setProperty("mail.password", "bezlosmija");
	    properties.setProperty("mail.port", "587");
	    properties.put("mail.smtp.host", "smtp.gmail.com"); 
	    properties.put("mail.smtp.socketFactory.port", "465"); 
	    properties.put("mail.smtp.socketFactory.class", 
	    "javax.net.ssl.SSLSocketFactory"); 
	    properties.put("mail.smtp.auth", "true"); 
	    properties.put("mail.smtp.port", "465"); 
		Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
 
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "sdmrbg123@gmail.com", "bezlosmija");
                    }
                });
		
		try { 
			MimeMessage message = new MimeMessage(session); 
			message.setFrom(new InternetAddress("sdmrbg123@gmail.com")); 
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
			message.setSubject(subject); 
			message.setText(content); 

			//send message 
			Transport.send(message); 
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} 
		
		logger.info("Sending...");
		
		logger.info("Done!");
	}
}