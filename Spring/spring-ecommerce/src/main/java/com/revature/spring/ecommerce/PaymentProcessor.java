package com.revature.spring.ecommerce;

public class PaymentProcessor {
    public PaymentProcessor(CreditCard creditCard) {
        System.out.println("Credit card instance payment processed!");
    }

    public PaymentProcessor(PayPal payPal) {
        System.out.println("PayPal instance payment processed!");
    }
}
