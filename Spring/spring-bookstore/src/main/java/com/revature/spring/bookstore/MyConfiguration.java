package com.revature.spring.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.revature.spring.bookstore")
public class MyConfiguration {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService();
    }

    @Bean
    public InvoiceService invoiceService() {
        return new InvoiceService();
    }

}