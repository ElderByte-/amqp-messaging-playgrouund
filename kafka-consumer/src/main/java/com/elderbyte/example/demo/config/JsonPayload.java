package com.elderbyte.example.demo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

/**
 * Represents a generic JSON object
 */
public class JsonPayload {


    public static JsonPayload Empty = new JsonPayload(null, null);

    public static JsonPayload from(ObjectMapper objectMapper, byte[] data){
        if(objectMapper == null) throw new IllegalArgumentException("objectMapper must not be null!");
        try {
            JsonNode node = objectMapper.readTree(data);
            return new JsonPayload(objectMapper, node);
        }catch (Exception e){
            throw new RuntimeException("Failed to deserialize bytes into JSON", e);
        }

    }

    public static JsonPayload from(ObjectMapper objectMapper, JsonNode node){
        if(objectMapper == null) throw new IllegalArgumentException("objectMapper must not be null!");
        return new JsonPayload(objectMapper, node);
    }


    private final ObjectMapper objectMapper;
    private final JsonNode jsonNode;


    private JsonPayload(ObjectMapper objectMapper, JsonNode node){
        this.objectMapper = objectMapper;
        this.jsonNode = node;
    }

    public Optional<JsonNode> getJsonNode(){
        return Optional.ofNullable(jsonNode);
    }

    public <T> Optional<T> json(Class<T> clazz){
        if(jsonNode != null){
            try {
                return Optional.of(objectMapper.treeToValue(jsonNode, clazz));
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Failed to map json node to class " + clazz.getCanonicalName(), e);
            }
        }else{
            return Optional.empty();
        }
    }

}