package com.siri_hate.backend_service_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendService1Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(BackendService1Application.class, args);
    }

}