package com.example.apptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApptestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApptestApplication.class, args);
    }

}
