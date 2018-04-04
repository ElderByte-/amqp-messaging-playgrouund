package com.elderbyte.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfiguration {

    @Bean
    public NewTopic topicFoobar() {
        return new NewTopic("foobar", 10, (short)1);
    }

    @Bean
    public NewTopic topicBar() {
        return new NewTopic("bar", 10, (short) 1);
    }

}
