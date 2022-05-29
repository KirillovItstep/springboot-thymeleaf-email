package org.itstep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
    public class EmailController {

    @Autowired
    EmailService emailService;

        @RequestMapping("/send")
        public String send(Model model) throws MessagingException {
            Email email = new Email();
            email.setTo("kirillov203509@gmail.com");
            email.setFrom("kirillov203509@gmail.com");
            email.setSubject("Welcome Email from CodingNConcepts");
            email.setTemplate("welcome-email.html");
            Map<String, Object> properties = new HashMap<>();
            properties.put("name", "Ashish");
            properties.put("subscriptionDate", LocalDate.now().toString());
            properties.put("technologies", Arrays.asList("Python", "Go", "C#"));
            email.setProperties(properties);
            emailService.sendHtmlMessage(email);
            return "success.html";
        }

    @RequestMapping("/sendsimple")
    public String sendSimple(Model model) throws MessagingException {
        Email email = new Email();
        email.setTo("kirillov203509@gmail.com");
        email.setFrom("kirillov203509@gmail.com");
        email.setSubject("Welcome Email from CodingNConcepts");
        email.setText("Simple text");
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Ashish");
        properties.put("subscriptionDate", LocalDate.now().toString());
        properties.put("technologies", Arrays.asList("Python", "Go", "C#"));
        email.setProperties(properties);
        emailService.sendSimpleMessage(email);
        return "success.html";
    }
    }
