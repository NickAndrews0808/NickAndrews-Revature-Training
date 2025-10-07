package com.revature.spring.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.revature.spring.annotations")
public class MyConfiguration {

    // Creates a bean with the method name as the bean ID
    @Bean
    public MyService myService() {
        return new MyService();
    }

}
