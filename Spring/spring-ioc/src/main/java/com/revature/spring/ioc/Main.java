package com.revature.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Retrieve the bean from the Spring container
        MessageService myMsg = (MessageService)context.getBean("messageService");
        // Call a method on the bean
        myMsg.printMessage();

        myMsg = (MessageService)context.getBean("messageSetter");
        myMsg.printMessage();
        
        // Close the context to trigger destroy methods
        ((ClassPathXmlApplicationContext) context).close();
    }
} 