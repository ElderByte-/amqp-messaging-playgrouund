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
			value = @Queue(value = "sample-queue-image", durable = "true"),
			exchange = @Exchange(value = "spring-boot-exchange", type = ExchangeTypes.TOPIC),
			key = "sample.routing.key.image.#")
	)
	public void receiveMessageImage(SampleMessageDto message) {
		System.out.println("receiveMessageImage <" + message + ">");
	}

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "sample-queue-video", durable = "true"),
			exchange = @Exchange(value = "spring-boot-exchange", type = ExchangeTypes.TOPIC),
			key = "sample.routing.key.video.#")
	)
	public void receiveMessageVideo(SampleMessageDto message) {
		System.out.println("receiveMessageVideo <" + message + ">");
	}

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "sample-queue-pdf", durable = "true"),
			exchange = @Exchange(value = "spring-boot-exchange", type = ExchangeTypes.TOPIC),
			key = "sample.routing.key.application.pdf")
	)
	public void receiveMessagePdf(SampleMessageDto message) {
		System.out.println("receiveMessagePdf <" + message + ">");
	}



}


