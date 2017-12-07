package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SampleMessageConsumer {

	@RabbitListener(queues = "sample-queue")
	public void receiveMessage(SampleMessageDto message) {
		System.out.println("Consumer Received <" + message + ">");
	}
}


