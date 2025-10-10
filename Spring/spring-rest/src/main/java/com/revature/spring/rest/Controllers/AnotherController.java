package com.revature.spring.rest.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@RestController
public class AnotherController {

    @GetMapping("/greet")
    public String greetUser(@RequestParam String name) {
        return "Greetings, " + name.toUpperCase() + "!";
    }

    @GetMapping("/add")
    public String addNumbers(@RequestParam int a, @RequestParam int b) {
        return "The sum is: " + (a + b);
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id){
        return "User ID: " + id;
    }

    @GetMapping("/user/{id}/order/{orderId}")
    public String getOrderForUser(@PathVariable int id, @PathVariable int orderId) {
        return "User ID: " + id + ", Order ID: " + orderId;
    }

    @GetMapping("/username/{name}")
    public String getUserName(@PathVariable String name) {
        return "User Name: " + name.toUpperCase();
    }

    @GetMapping("/divide")
    public String divideNumbers(@RequestParam int a, @RequestParam int b) {
        return "The result is: " + ((double) a / b);
    }
}
