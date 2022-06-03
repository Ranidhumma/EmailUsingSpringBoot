package com.bridgelabz.springemaildemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,
                                String subject,
                                String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ranidhumma8@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail Send Finally..");

    }
    public void sendEmailWithAttachment(String toEmail,
                                        String subject,
                                        String body,
                                        String attachment) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("ranidhumma8@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body);

        FileSystemResource fileSystem
                = new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(),
                fileSystem);

        mailSender.send(mimeMessage);
        System.out.println("Mail Send...");
    }
    }


