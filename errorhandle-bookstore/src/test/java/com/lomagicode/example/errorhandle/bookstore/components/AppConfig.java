package com.lomagicode.example.errorhandle.bookstore.components;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created on Oct 10, 2018
 *
 * @author Chuan Qin
 */
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//         return builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
        return builder.build();
    }
}
