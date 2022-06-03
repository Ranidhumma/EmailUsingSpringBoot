package com.bridgelabz.springemaildemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailDemoApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailDemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//		senderService.sendEmail("ranidhumma8@gmail.com",
//				"Subject : Msg using Springboot",
//				"Hey");

		senderService.sendEmailWithAttachment("ranidhumma8@gmail.com",
				"Email with attachment" ,
				"This is email body with attachment..",
				"C:\\Users\\SHREE\\Pictures\\Saved Pictures\\nature.jpg");

	}
}


