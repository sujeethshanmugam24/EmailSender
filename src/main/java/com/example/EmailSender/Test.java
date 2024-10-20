package com.example.EmailSender;

import jakarta.mail.Session;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class Test {
    public static void main(String[] args) {
        final String username = "xxxxx@gmail.com"; // Replace with your email
        final String password = "pwd"; // Replace with your app password

        // Set up properties for the mail session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a session with an authenticator
        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("xxxxx@gmail.com")); // Replace with your "from" email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("xxxxx@gmail.com")); // Replace with the recipient's email
            message.setSubject("Test Subject");
            message.setText("Test Body");

            // Send the message
            Transport.send(message);
            System.out.println("Email Sent Successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
