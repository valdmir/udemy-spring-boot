package com.bivala.backend.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloRestController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

}
