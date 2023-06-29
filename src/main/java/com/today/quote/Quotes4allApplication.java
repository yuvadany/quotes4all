package com.today.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;

@SpringBootApplication
public class Quotes4allApplication {

    public static void main(String[] args) {

        SpringApplication.run(Quotes4allApplication.class, args);
    }

}
