package com.bridgelabz.bookstore.utility;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers("/bookstore/**","/books/**")
                .permitAll().anyRequest().authenticated().and().httpBasic();
        return httpSecurity.build();
    }





}