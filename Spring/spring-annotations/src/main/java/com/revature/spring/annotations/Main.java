package com.revature.spring.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring container
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        // Retrieve the NotificationService bean
        NotificationService notificationService = context.getBean(NotificationService.class);
        notificationService.getNotification();

        // Retrieve and use MyService bean
        MyService myService = context.getBean("myService", MyService.class);
        myService.doSomething();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}