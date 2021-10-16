package com.example.CryptoExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.rest"})
@SpringBootApplication
public class CryptoExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoExchangeApplication.class, args);
    }

}
