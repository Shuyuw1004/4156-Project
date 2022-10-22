package com.humanlearning.rentermatch.config;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    public void configure(HttpSecurity http){
        http
                .authorizeRequests()
                .antMatchers("").authenticated()
                .antMatchers("/").permitAll();
    }
}
