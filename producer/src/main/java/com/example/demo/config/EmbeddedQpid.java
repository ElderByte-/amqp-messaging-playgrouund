package com.example.demo.config;

import org.apache.qpid.server.Broker;
import org.apache.qpid.server.BrokerOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class EmbeddedQpid {

    @Value("${spring.rabbitmq.port}")
    private String amqpPort;

    @Value(("${spring.rabbitmq.virtual-host}"))
    private String virtualHost;


    public EmbeddedQpid() {
    }

    @PostConstruct
    public void startBroker(){

        System.out.println("Starting QPID Broker @ " + virtualHost + " - port " + amqpPort + "... ");

        Broker broker = new Broker();
        BrokerOptions brokerOptions = new BrokerOptions();
        brokerOptions.setConfigProperty("qpid.amqp_port", amqpPort);
        brokerOptions.setConfigProperty("qpid.broker.defaultPreferenceStoreAttributes", "{\"type\": \"Noop\"}");
        brokerOptions.setConfigProperty("qpid.vhost", virtualHost);
        brokerOptions.setConfigurationStoreType("Memory");
        brokerOptions.setStartupLoggedToSystemOut(false);
        try {
            broker.startup(brokerOptions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
