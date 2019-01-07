package com.wkodate.technews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TechNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechNewsApplication.class, args);
    }
}
