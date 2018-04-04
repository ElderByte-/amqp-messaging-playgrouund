package com.elderbyte.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Import(DefaultJsonProducerConfiguration.class)
public class KafkaStarterAutoConfiguration {

    @Bean
    public KafkaClientConfig kafkaClientConfig(){
        return new KafkaClientConfig();
    }

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaClientConfig().getKafkaServers());
        return new KafkaAdmin(configs);
    }
}
