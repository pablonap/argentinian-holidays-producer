package com.practiceproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The {@code ApplicationConfig} class is configuration component
 * to create new beans used as dependencies across the application.
 *
 * @author pablo.napoli
 *
 */
@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}
