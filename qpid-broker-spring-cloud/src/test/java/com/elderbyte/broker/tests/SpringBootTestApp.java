package com.elderbyte.broker.tests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.UnknownHostException;

@SpringBootApplication
public class SpringBootTestApp {

    public static void main(String[] args) throws UnknownHostException {

        SpringApplication app = new SpringApplication(SpringBootTestApp.class);
        Environment env = app.run(args).getEnvironment();

    }

}
