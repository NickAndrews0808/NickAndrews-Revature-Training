package com.revature.spring.bookstore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load the Spring container
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        // Retrieve the BookService bean
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.doSomething();

        // Retrieve the PaymentService bean
        PaymentService paymentService = context.getBean("paymentService", PaymentService.class);
        paymentService.generatePayment();

        // Retrieve the InvoiceService bean
        InvoiceService invoiceService = context.getBean("invoiceService", InvoiceService.class);
        invoiceService.generateInvoice();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}