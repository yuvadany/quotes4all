package com.today.quote.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name="swagger.enabled", havingValue = "true", matchIfMissing = false)
public class SwaggerConfig {

    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-apis")
                .apiInfo(getApiInfos())
                .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }

    public ApiInfo getApiInfos(){
        return new ApiInfoBuilder()
                .title("... Spring Boot Project For Best Quotes for the Day ... ")
                .description("It has all Quotes for all situation to encourage you ")
                .version("1")
                .build();
    }

}