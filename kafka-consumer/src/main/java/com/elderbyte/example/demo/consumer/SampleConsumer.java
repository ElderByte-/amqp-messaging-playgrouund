package com.elderbyte.example.demo.consumer;

import com.elderbyte.example.demo.SampleMessageDto;
import com.elderbyte.kafka.serialisation.Json;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleConsumer {

    private static final Logger log = LoggerFactory.getLogger(SampleConsumer.class);


    /*
    @KafkaListener(groupId= "worker-group-batch", topics = "foobar", containerFactory = "kafkaBatchFactory")
    public void onMessage(List<ConsumerRecord<String, Json>> batch, Acknowledgment ack){
        log.info("Received batch: " + batch.size());

        if(false){ // ALWAYS FAIL :D
           throw new IllegalStateException("Failed to process messages temporarily!");
        }

        batch.forEach(this::onReccord);
        ack.acknowledge();
    }*/

    /**/
    @KafkaListener(groupId= "worker-group", topics = "foobar")
    public void onMessage(ConsumerRecord<String, Json> record, Acknowledgment ack){
        onReccord(record);
        ack.acknowledge();
    }


    private void onReccord(ConsumerRecord<String, Json> record){

        String key = record.key();
        var dto = record.value().json(SampleMessageDto.class).orElse(null);

        onReccord(key, dto);
    }

    private void onReccord(String key, SampleMessageDto message){
        log.info("RECORD k:: " + key + ", MESSAGE:: " + message);
    }
}
