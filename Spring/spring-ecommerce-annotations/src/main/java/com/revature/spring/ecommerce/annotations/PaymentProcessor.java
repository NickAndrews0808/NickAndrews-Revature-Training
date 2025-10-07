package com.revature.spring.ecommerce.annotations;

import org.springframework.beans.factory.annotation.Autowired;

public class PaymentProcessor {
    @Autowired
    private PaymentService paymentService;
    
    public PaymentProcessor(CreditCard creditCard) {
        this.paymentService = creditCard;
        System.out.println("Credit card instance payment processed!");
    }

    public PaymentProcessor(PayPal payPal) {
        this.paymentService = payPal;
        System.out.println("PayPal instance payment processed!");
    }

    @Autowired
    public PaymentService getPaymentService() {
        return paymentService;
    }
}
