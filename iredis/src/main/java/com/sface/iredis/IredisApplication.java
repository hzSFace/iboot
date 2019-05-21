package com.sface.iredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IredisApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(IredisApplication.class, args);
    }
}