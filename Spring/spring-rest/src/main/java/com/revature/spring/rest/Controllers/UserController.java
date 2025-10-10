package com.revature.spring.rest.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.spring.rest.model.User;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    
    @GetMapping("/user")
    public User getUser() {
        return new User("Alice", 21);
    }

    // ResponseEntity contains the body, headers, and status code (everything)
    @GetMapping("/user-1")
    public ResponseEntity<User> getUser1() {
        User user = new User("Bob", 25);
        return ResponseEntity.ok(user);
    }
    

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return List.of(
            new User("Charlie", 30),
            new User("Dave", 35)
        );
    }

    // You can user the same endpoint for different HTTP methods
    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        System.out.println("Creating user: " + user.getName() + ", age: " + user.getAge());
        return ResponseEntity.ok("User " + user.getName() + " created");
    }
}