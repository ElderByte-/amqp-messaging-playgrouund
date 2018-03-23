package com.example.demo;

import com.elderbyte.broker.EnableEmbeddedBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableEmbeddedBroker
@SpringBootApplication
public class DemoProducerAndBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProducerAndBrokerApplication.class, args);
	}
}
