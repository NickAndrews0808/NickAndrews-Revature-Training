package com.revature.spring.ecommerce;

public class CreditCard implements PaymentService {
    public CreditCard() {
        System.out.println("CreditCard instance created!");
    }

    public void pay() {
        PaymentProcessor pp = new PaymentProcessor(this);
    }
}
