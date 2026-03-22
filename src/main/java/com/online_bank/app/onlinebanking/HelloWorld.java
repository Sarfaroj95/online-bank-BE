package com.online_bank.app.onlinebanking;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String hello() {
        return "Hello World Java App";
    }
}
