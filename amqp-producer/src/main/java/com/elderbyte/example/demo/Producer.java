package com.elderbyte.example.demo;

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
				new SampleMessageDto("Sample Max Message", number++, 7.56464646, "application/max"));

		send(
				new SampleMessageDto("Sample JPG Message", number++, 7.56464646, "image/jpg"));

		send(
				new SampleMessageDto("Sample BMP Message", number++, 7.56464646, "image/bmp"));

		send(
				new SampleMessageDto("Sample Message", number++, 7.56464646, "video/mp4"));

		send(
				new SampleMessageDto("Sample PDF Message", number++, 7.56464646, "application/pdf")
		);


		System.out.println("PRODUC --->: Messages where sent to the Queue");
	}

	private void send(SampleMessageDto msg) {
		String[] typeParts =  msg.mimeType.split("/");
		String routingKey = "sample.routing.key." + typeParts[0] + "." + typeParts[1];
		this.amqpTemplate.convertAndSend("spring-boot-exchange", routingKey, msg);
	}

}