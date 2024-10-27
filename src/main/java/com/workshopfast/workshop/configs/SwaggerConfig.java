package com.workshopfast.workshop.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI configAPI(){
        return new OpenAPI().info(new Info().title("WorkshopApplication").version("1.0").description("Workshop APIREST"));
    }
}
