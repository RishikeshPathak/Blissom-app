package com.blissom.gateway.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.blissom.gateway.controller.AuthController;

@Configuration
public class SecurityConfig {
	private Logger logger = LoggerFactory.getLogger(AuthController.class);
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
    	logger.info("SecurityWebFilterChain IN.....");
        httpSecurity
            .cors().and() // Enable CORS
            .authorizeExchange()
            .anyExchange()
            .authenticated()
            .and()
            .oauth2Client()
            .and()
            .oauth2ResourceServer()
            .jwt();
        return httpSecurity.build();
    }
}

