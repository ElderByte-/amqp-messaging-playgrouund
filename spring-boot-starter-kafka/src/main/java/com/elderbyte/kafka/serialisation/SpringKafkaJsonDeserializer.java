package com.elderbyte.kafka.serialisation;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;


/**
 * Generic JSON deserializer.
 */
public class SpringKafkaJsonDeserializer implements Deserializer<JsonPayload> {


  private ObjectMapper objectMapper;

  /**
   * Default constructor needed by Kafka
   */
  public SpringKafkaJsonDeserializer() {

  }

  @Override
  public void configure(Map<String, ?> props, boolean isKey) {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
  }


  @Override
  public JsonPayload deserialize(String ignored, byte[] bytes) {
    if (bytes == null || bytes.length == 0) {
      return JsonPayload.Empty;
    }

    try {
      return JsonPayload.from(objectMapper, bytes);
    } catch (Exception e) {
      throw new SerializationException(e);
    }
  }


  @Override
  public void close() { }
}