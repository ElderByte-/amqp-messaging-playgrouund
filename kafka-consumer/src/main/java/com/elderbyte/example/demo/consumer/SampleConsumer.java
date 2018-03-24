package com.elderbyte.example.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SampleConsumer {

    private static final Logger log = LoggerFactory.getLogger(SampleConsumer.class);


    @KafkaListener(id = "qux", topics = "foobar")
    public void onMessage(ConsumerRecord<?, ?> record){

        log.info("GOT KAFKA RECORD: " + record.toString());
    }
}
