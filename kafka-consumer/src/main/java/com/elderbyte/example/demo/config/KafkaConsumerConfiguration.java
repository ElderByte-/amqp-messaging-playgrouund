package com.elderbyte.example.demo.config;


import com.elderbyte.kafka.config.KafkaClientConfig;
import com.elderbyte.kafka.serialisation.Json;
import com.elderbyte.kafka.serialisation.SpringKafkaJsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaConsumerConfiguration {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    /*
    @Autowired
    private KafkaClientConfig config;

    @Autowired
    private SpringKafkaJsonDeserializer springKafkaJsonDeserializer;


    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Json>>
    kafkaListenerContainerFactory() {
        var factory = buildJsonContainerFactory(consumerFactory());
        return factory;
    }


    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Json>>
    kafkaBatchFactory() {
        var factory = buildJsonContainerFactory(consumerFactory());
        factory.setBatchListener(true);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, Json> consumerFactory() {
        var factory = new DefaultKafkaConsumerFactory<String, Json>(consumerConfigs());
        factory.setKeyDeserializer(new StringDeserializer());
        factory.setValueDeserializer(springKafkaJsonDeserializer);

        return factory;
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, config.getKafkaServers());
        // props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        config.getConsumerMaxPollRecords().ifPresent(max ->  props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, max));
        return props;
    }

    private ConcurrentKafkaListenerContainerFactory<String, Json> buildJsonContainerFactory(ConsumerFactory<String, Json> consumerFactory){
        var factory = new ConcurrentKafkaListenerContainerFactory<String, Json>();
        factory.setConsumerFactory(consumerFactory);
        config.getConsumerConcurrency().ifPresent(c -> factory.setConcurrency(c));
        config.getConsumerPollTimeout().ifPresent(t -> factory.getContainerProperties().setPollTimeout(t));


        // factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL);
        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.BATCH);
        return factory;
    }*/
}
