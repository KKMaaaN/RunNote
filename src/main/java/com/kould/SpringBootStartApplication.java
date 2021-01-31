package com.kould;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringBootStartApplication extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure
            (SpringApplicationBuilder builder) {
        return builder.sources(SpringBootStartApplication.class) ;
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(SpringBootStartApplication.class,args) ;
    }
}
