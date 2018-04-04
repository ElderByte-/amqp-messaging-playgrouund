package com.elderbyte.kafka.serialisation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Serialize objects to UTF-8 JSON. This works with any object which is serializable with Jackson.
 */
public class SpringKafkaJsonSerializer implements Serializer<Object> {

  private ObjectMapper objectMapper;

  /**
   * Default constructor needed by Kafka
   */
  public SpringKafkaJsonSerializer() {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
  }

  @Override
  public void configure(Map<String, ?> config, boolean isKey) {
    // NOP
  }


  @Override
  public byte[] serialize(String topic, Object data) {
    if (data == null) {
      return null;
    }

    try {
      return objectMapper.writeValueAsBytes(data);
    } catch (Exception e) {
      throw new SerializationException("Error serializing JSON message", e);
    }
  }

  @Override
  public void close() {
  }

}