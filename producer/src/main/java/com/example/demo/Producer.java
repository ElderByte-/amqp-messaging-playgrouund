package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	private AmqpTemplate amqpTemplate;


	//@PostConstruct
	public void send() throws Exception {
		send("Sample message");
		System.out.println("PRODUC --->: Message was sent to the Queue");
	}

	public void send(String msg) {
		this.amqpTemplate.convertAndSend("sample-queue", msg);
	}

}