package com.broadridge.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	   @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        // Redirect HTTP to HTTPS
	        http.requiresChannel()
	            .anyRequest()
	            .requiresSecure();
	    }

}
