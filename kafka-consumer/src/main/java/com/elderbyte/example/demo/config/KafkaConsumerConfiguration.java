package com.elderbyte.example.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Deprecated
public class KafkaConsumerConfiguration {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
