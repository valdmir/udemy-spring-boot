package com.bivala.springbootbackend.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach{
    public TennisCoach(){

        System.out.println("called constructor "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Tennis Coach daily workout";
    }
}
