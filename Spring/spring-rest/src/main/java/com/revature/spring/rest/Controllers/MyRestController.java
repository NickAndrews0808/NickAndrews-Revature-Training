package com.revature.spring.rest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Combination of @Controller and @ResponseBody
//@RequestMapping("/api/vi")
public class MyRestController {
    
    @GetMapping("/howdy")
    public String howdy() {
        return "Howdy!";
    }
}
