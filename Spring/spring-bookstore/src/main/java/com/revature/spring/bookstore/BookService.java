package com.revature.spring.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    
    // Field Injection
    @Autowired
    PaymentService paymentService;

    @Autowired
    InvoiceService invoiceService;

    // Constructor Injection
    @Autowired
    public BookService(PaymentService paymentService, InvoiceService invoiceService) {
        this.paymentService = paymentService;
        this.invoiceService = invoiceService;
    }

    public void doSomething() {
        System.out.print("Invoice: ");
        invoiceService.generateInvoice();
        System.out.print("Payment: ");
        paymentService.generatePayment();
    }
}
