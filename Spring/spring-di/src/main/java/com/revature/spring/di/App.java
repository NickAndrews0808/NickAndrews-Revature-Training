package com.revature.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load the Spring application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the NotificationService bean and use it
        NotificationService service = (NotificationService) context.getBean("notificationService");
        service.sendNotification("Hello, this is a test notification!");

        SMSService smsService = (SMSService) context.getBean("smsService");
        smsService.printMessage();

        EmailService emailService = (EmailService) context.getBean("emailService");
        emailService.printMessage();

        // Close the application context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
