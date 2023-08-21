package com.bivala.springbootbackend.springbootbackend.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
//    expose "/" that return "hello world"
    @Value("${app.creator}")
    private String appCreator;
    @Value("${app.name}")
    private String appName;
    @GetMapping("/")

    public String sayHello(){
        return "hello world "+appCreator+", this is from "+appName;
    }
//    expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is you lucky day";
    }
}
