package com.elderbyte.example.demo.consumer;

import com.elderbyte.example.demo.SampleMessageDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SampleConsumer {

    private static final Logger log = LoggerFactory.getLogger(SampleConsumer.class);


    @KafkaListener(groupId= "worker-", topics = "foobar")
    public void onMessage(ConsumerRecord<String, SampleMessageDto> record){

        log.info("GOT KAFKA RECORD: " + record.toString());
    }
}
