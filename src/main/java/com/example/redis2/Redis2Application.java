package com.example.redis2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Redis2Application {

    public static void main(String[] args) {
        SpringApplication.run(Redis2Application.class, args);
    }

}
