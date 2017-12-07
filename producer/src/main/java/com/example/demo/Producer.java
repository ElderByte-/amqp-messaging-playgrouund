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
		send(new SampleMessageDto("Sample Message", number++, 7.56464646));
		System.out.println("PRODUC --->: Message was sent to the Queue");
	}

	public void send(SampleMessageDto msg) {
		this.amqpTemplate.convertAndSend("sample-queue", msg);
	}

}