package com.bivala.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
   @Bean
   public UserDetailsManager userDetailsManager(DataSource dataSource){
       JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
//       define query to retrieve a user by username for custom table or query
       jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username,password,enabled FROM user_access where username=?");
//       define query to retrieve a role by username for custom table or query
       jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT username,role FROM authorities where username=?");

       return jdbcUserDetailsManager;
   }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
          configure->configure
                  .requestMatchers(HttpMethod.GET,"api/employees").hasRole("EMPLOYEE")
                  .requestMatchers(HttpMethod.GET,"api/employees/**").hasRole("EMPLOYEE")
                  .requestMatchers(HttpMethod.POST,"api/employees").hasRole("MANAGER")
                  .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("MANAGER")
                  .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
//        DISABLE CSRF
        http.csrf(csrf->csrf.disable());
        return http.build();
    }

//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john= User.builder().username("john")
//                .password("{noop}test123").roles("EMPLOYEE").build();
//
//        UserDetails susan= User.builder().username("susan")
//                .password("{noop}test1234").roles("EMPLOYEE","MANAGER").build();
//        UserDetails mary= User.builder().username("mary")
//                .password("{noop}test12345").roles("EMPLOYEE","MANAGER","ADMIN").build();
//        return new InMemoryUserDetailsManager(john,mary,susan);
//    }
}
