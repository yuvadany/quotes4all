package com.today.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Quotes4allApplication {

    public static void main(String[] args) {

        SpringApplication.run(Quotes4allApplication.class, args);
    }

    @Bean
    public WebClient.Builder getWebClient() {
        return WebClient.builder();
    }
}
