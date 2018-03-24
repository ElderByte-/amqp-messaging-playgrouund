package com.elderbyte.kafka.embedded;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import( { KafkaEmbeddedConfig.class } )
public @interface EnableEmbeddedKafka {

}
