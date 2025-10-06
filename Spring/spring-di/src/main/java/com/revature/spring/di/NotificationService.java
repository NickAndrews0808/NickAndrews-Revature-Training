package com.revature.spring.di;

public class NotificationService {
    private EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendNotification(String message) {
        System.out.println("Sending notification: " + emailService.getMessage());
    }
}
