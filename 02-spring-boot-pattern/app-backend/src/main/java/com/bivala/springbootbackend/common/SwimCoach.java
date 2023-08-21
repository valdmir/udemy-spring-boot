package com.bivala.springbootbackend.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("called constructor "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return getClass().getSimpleName()+" daily workout";
    }
}
