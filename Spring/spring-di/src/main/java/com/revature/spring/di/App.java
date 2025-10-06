package com.revature.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load the Spring application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        NotificationService notificationService = context.getBean(NotificationService.class);
        notificationService.sendNotification("Hello, this is a test notification!");
    }
}
