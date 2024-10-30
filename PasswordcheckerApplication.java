package com.example.passwordchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class PasswordcheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasswordcheckerApplication.class, args);
    }
}

