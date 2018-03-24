package com.elderbyte.example.demo;

import com.elderbyte.kafka.embedded.KafkaEmbeddedConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    public SampleKafkaProducer producer;

    @GetMapping
    public String hello(){
        return "welcome to amqp producer";
    }

    @GetMapping("/test")
    public void test(){
        log.info("Producing test messages ...");

        try {
            producer.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/bulk")
    public void testBulk(){
        log.info("Producing bulk messages ...");
        try {
            producer.sendBulk(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
