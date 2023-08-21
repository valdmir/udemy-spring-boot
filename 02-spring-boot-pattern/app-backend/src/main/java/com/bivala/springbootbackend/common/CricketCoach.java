package com.bivala.springbootbackend.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary //ini buat maksa punya default dependency injection
//@Lazy // ini buat bkin hanya kepanggil kalau emank dipanggil
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class CricketCoach implements Coach {
    public  CricketCoach(){

        System.out.println("called constructor "+getClass().getSimpleName());
    }
    @PostConstruct
    public void callWhenAfterConstructor(){
        System.out.println("after constructor:  "+getClass().getSimpleName());

    }
    @PreDestroy
    public void callBeforeDestroy(){
        System.out.println("after destroy:  "+getClass().getSimpleName());

    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!!!!!!!!!!! -> setter injection";
    }
}
