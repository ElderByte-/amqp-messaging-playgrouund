package com.elderbyte.example.demo.consumer;

import com.elderbyte.example.demo.SampleMessageDto;
import com.elderbyte.kafka.serialisation.JsonPayload;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SampleConsumer {

    private static final Logger log = LoggerFactory.getLogger(SampleConsumer.class);

    @KafkaListener(groupId= "worker-group", topics = "foobar")
    public void onMessage(ConsumerRecord<String, JsonPayload> record){
        onMessage(record.value().json(SampleMessageDto.class).orElse(null));
    }

    private void onMessage(SampleMessageDto message){
        log.info("GOT KAFKA MESSAGE:: " + message);
    }
}
