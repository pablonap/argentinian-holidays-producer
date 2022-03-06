package com.practiceproject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

/**
 * The {@code AutoCreateConfig} class is configuration component
 * to create a new bean for a Kafka topic.
 * Use this component only in local environment, never in production.
 *
 * @author pablo.napoli
 *
 */
@Configuration
@Profile("local")
public class AutoCreateConfig {
    @Bean
    public NewTopic holidayEvents(){
        return TopicBuilder.name("holiday-events")
                .partitions(1)
                .replicas(1)
                .build();
    }
}