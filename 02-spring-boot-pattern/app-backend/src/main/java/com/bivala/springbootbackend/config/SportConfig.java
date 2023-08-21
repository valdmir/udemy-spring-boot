package com.bivala.springbootbackend.config;

import com.bivala.springbootbackend.common.Coach;
import com.bivala.springbootbackend.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
