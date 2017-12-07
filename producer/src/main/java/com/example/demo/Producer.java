package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	private AmqpTemplate amqpTemplate;

	private static int number = 1;

	public void send() throws Exception {
		send(
				new SampleMessageDto("Sample Max Message", number++, 7.56464646),
				"sample.routing.key.max"
		);

		send(
				new SampleMessageDto("Sample Image Message", number++, 7.56464646),
				"sample.routing.key.image.jpeg"
		);

		send(
				new SampleMessageDto("Sample Message", number++, 7.56464646),
				"sample.routing.key.video.mp4"
		);

		send(
				new SampleMessageDto("Sample PDF Message", number++, 7.56464646),
				"sample.routing.key.document.pdf"
		);


		System.out.println("PRODUC --->: Messages where sent to the Queue");
	}

	public void send(SampleMessageDto msg, String routingKey) {
		this.amqpTemplate.convertAndSend("spring-boot-exchange", routingKey, msg);
	}

}