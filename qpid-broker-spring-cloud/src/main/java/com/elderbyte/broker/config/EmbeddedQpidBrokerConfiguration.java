package com.elderbyte.broker.config;

import org.apache.qpid.server.SystemLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Configures and starts an Qpid Message Broker.
 */
@Configuration
public class EmbeddedQpidBrokerConfiguration {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final String INITIAL_CONFIGURATION = "initial-config.json";
    SystemLauncher brokerLauncher;

    @Value("${server.qpid.port:5672}")
    private String amqpPort;

    @Value(("${server.qpid.virtual-host:default}"))
    private String virtualHost;


    public EmbeddedQpidBrokerConfiguration() {
    }


    @PostConstruct
    public void startBroker(){

        System.out.println("Starting QPID Broker @ " + virtualHost + " - port " + amqpPort + "... ");

        try{
            start();
        }catch (Exception e){
            throw new RuntimeException("Failed to start embedded QPID broker!", e);
        }
    }

    @PreDestroy
    public void shutdown(){
        log.info("Shutting down broker...");
        brokerLauncher.shutdown();
    }

    private void start() throws Exception {
        brokerLauncher = new SystemLauncher();
        brokerLauncher.startup(createSystemConfig());
    }

    private Map<String, Object> createSystemConfig(){
        Map<String, Object> attributes = new HashMap<>();
        URL initialConfig = EmbeddedQpidBrokerConfiguration.class.getClassLoader().getResource(INITIAL_CONFIGURATION);
        attributes.put("type", "Memory");
        attributes.put("initialConfigurationLocation", initialConfig.toExternalForm());
        attributes.put("startupLoggedToSystemOut", true);
        attributes.put("qpid.amqp_port", amqpPort);
        attributes.put("qpid.http_port", 8085);
        attributes.put("qpid.vhost", virtualHost);

        /* Old config
        brokerOptions.setConfigProperty("qpid.amqp_port", amqpPort);
        brokerOptions.setConfigProperty("qpid.http_port", "8085");
        brokerOptions.setConfigProperty("qpid.broker.defaultPreferenceStoreAttributes", "{\"type\": \"Noop\"}");
        brokerOptions.setConfigProperty("qpid.vhost", virtualHost);
        brokerOptions.setConfigurationStoreType("Memory");
        brokerOptions.setStartupLoggedToSystemOut(false);
         */


        return attributes;
    }
}
