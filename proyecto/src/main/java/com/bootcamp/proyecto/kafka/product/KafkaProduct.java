package com.bootcamp.proyecto.kafka.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProduct {


    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProduct.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProduct(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info("Producing message {}", message);
        this.kafkaTemplate.send("quickstart-events", message);
    }

}