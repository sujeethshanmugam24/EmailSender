package com.example.EmailSender;


import org.springframework.mail.MailException;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/")
    public String home(){
        return "email.jsp";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("toEmail") String toEmail,
                            @RequestParam("subject") String subject,
                            @RequestParam("body") String body,
                            Model model) {
        //List<String> recipients = Arrays.asList(toEmail.split(",\\s*"));
        try {
            emailService.sendSimpleEmail(toEmail, subject, body);
            model.addAttribute("message", "Email sent successfully!");
        } catch (MailException e) {
            model.addAttribute("message", "Failed to send email: " + e.getMessage());
            e.printStackTrace();  // Log the error details
        } catch (Exception e) {
            model.addAttribute("message", "An error occurred: " + e.getMessage());
            e.printStackTrace();  // Log the error details
        }
        return "result.jsp";
    }
}
