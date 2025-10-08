package com.revature.spring.boot.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SpringBootAssignment {
   public static void main(String[] args) {
      SpringApplication.run(SpringBootAssignment.class, args);
   }
}
