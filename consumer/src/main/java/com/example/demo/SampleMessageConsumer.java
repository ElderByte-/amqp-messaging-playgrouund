package com.example.demo;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SampleMessageConsumer {

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "sample-queue", durable = "true"),
			exchange = @Exchange(value = "spring-boot-exchange", type = ExchangeTypes.TOPIC),
			key = "sample.routing.key")
	)
	public void receiveMessage(SampleMessageDto message) {
		System.out.println("Consumer Received <" + message + ">");
	}
}


