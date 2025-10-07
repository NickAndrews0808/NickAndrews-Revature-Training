package com.revature.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    // Field Injection
    @Autowired
    EmailService emailService;

    // Constructor Injection
    @Autowired
    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    // Setter Injection
    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void getNotification() {
        System.out.println("Notification: " + emailService.getMessage());
    }
}
