package com.example.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("xxxxxx@gmail.com"); // Replace with your sender email
        message.setTo(toEmail.trim());
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
    public void sendSimpleEmail(List<String> toEmails, String subject, String body) {
        for (String toEmail : toEmails) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
            message.setFrom("xxxxxx@gmail.com");//from mail

            mailSender.send(message);
            System.out.println("Email sent successfully to: " + toEmail);
        }
    }
}
