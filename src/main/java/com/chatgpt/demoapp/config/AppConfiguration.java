package com.chatgpt.demoapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Value("${chatgpt.api.key}")
    private String apiKey;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder()
                .defaultHeader("Authorization", String.format("Bearer %s", apiKey))
                .build();
    }

}
