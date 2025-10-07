package com.revature.spring.ecommerce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        // Load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the bean from the Spring container
        CreditCard cc = (CreditCard)context.getBean("creditCardPayment");
        // Call a method on the bean
        cc.pay();

        // Close the context to trigger destroy methods
        ((ClassPathXmlApplicationContext) context).close();
    }
}