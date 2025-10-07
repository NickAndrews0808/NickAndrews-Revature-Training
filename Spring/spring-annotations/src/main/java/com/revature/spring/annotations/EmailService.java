package com.revature.spring.annotations;

import org.springframework.stereotype.Component;

// @Component
@Component("myEmail")
public class EmailService {
    public String getMessage() {
        return "You've got mail!";
    }

    
    public void someMethod() {
        System.out.println("This is some method in EmailService");
    }
}
