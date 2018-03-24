package com.example.demo.consumer;

import com.example.demo.SampleMessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "local.consumer.enabled", havingValue = "true")
public class LocalSampleMessageConsumer {

	@RabbitListener(queues = "sample-queue")
	public void receiveMessage(SampleMessageDto message) {
		System.out.println("Received Locally: <" + message + ">");
	}

}


