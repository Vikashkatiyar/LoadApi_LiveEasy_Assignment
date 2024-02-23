package com.liveasy.app.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author Vikash Katiyar
 * 
 */

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/load/**")
                        .allowedOrigins("*") // You can customize this to allow specific origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
