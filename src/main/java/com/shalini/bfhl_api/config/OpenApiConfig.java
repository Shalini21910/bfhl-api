package com.shalini.bfhl_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BFHL API")
                        .version("v0.0.1")
                        .description("BFHL processing API")
                        .contact(new Contact().name("BFHL Team").email("dev@example.com"))
                        .license(new License().name("MIT")));
    }
}
