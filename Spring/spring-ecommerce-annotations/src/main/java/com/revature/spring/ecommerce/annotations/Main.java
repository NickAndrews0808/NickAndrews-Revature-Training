package com.revature.spring.ecommerce.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.spring.ecommerce.annotations.PayPal;

public class Main {
    public static void main(String[] args) {
        // Load the Spring container
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        PayPal payPal = context.getBean("payPal", PayPal.class);
        payPal.pay();

        CreditCard creditCard = context.getBean("creditCard", CreditCard.class);
        creditCard.pay();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}