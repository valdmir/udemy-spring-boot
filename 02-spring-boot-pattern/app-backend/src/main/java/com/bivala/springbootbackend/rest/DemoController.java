package com.bivala.springbootbackend.rest;

import com.bivala.springbootbackend.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
//    define a private field for the dependency
    private Coach myCoach;
//     define  a constructor  for dependency injection
//    @Autowired
//    public DemoController(Coach theCoach){
//        myCoach=theCoach;
//    }
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach=theCoach;
//    }
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach){
        myCoach=theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
