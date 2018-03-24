package com.elderbyte.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleKafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

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
		kafkaTemplate.send("foobar", msg.id + "", msg.name);
	}

}