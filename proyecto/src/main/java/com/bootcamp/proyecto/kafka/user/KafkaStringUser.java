package com.bootcamp.proyecto.kafka.user;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

public class KafkaStringUser {
	
    Logger logger = LoggerFactory.getLogger(KafkaStringUser.class);

    @KafkaListener(topics = "quickstart-events" , groupId = "group_id")
    public void consume(String message) {
        logger.info("Consuming Message {}", message);
    }

}