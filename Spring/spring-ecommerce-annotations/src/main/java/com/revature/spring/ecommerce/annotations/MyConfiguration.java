package com.revature.spring.ecommerce.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.revature.spring.ecommerce.annotations")
public class MyConfiguration {

    // Creates a bean with the method name as the bean ID
    @Bean
    public PayPal payPal() {
        return new PayPal();
    }
}
