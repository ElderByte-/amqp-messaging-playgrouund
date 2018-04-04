package com.elderbyte.kafka.config;

import com.elderbyte.kafka.serialisation.JsonPayload;
import com.elderbyte.kafka.serialisation.SpringKafkaJsonDeserializer;
import com.elderbyte.kafka.serialisation.SpringKafkaJsonSerializer;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DefaultJsonConsumerConfiguration {

    @Autowired
    private KafkaClientConfig config;

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, JsonPayload>>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, JsonPayload> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, JsonPayload> consumerFactory() {
        DefaultKafkaConsumerFactory<String, JsonPayload> factory = new DefaultKafkaConsumerFactory<>(consumerConfigs());
        factory.setKeyDeserializer(new StringDeserializer());
        factory.setValueDeserializer(new SpringKafkaJsonDeserializer());

        return factory;
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, config.getKafkaServers());
        return props;
    }
}
