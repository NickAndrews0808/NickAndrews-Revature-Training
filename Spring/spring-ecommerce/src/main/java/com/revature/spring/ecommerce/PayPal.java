package com.revature.spring.ecommerce;

public class PayPal implements PaymentService {
    public PayPal() {
        System.out.println("PayPal instance created!");
    }

    public void pay() {
        PaymentProcessor pp = new PaymentProcessor(this);
    }
}
