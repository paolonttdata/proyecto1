package com.bootcamp.proyecto.kafka.controller;

import com.bootcamp.proyecto.kafka.product.KafkaProduct;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.proyecto.kafka.product.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProduct kafkaProduct;

    @Autowired
    KafkaController(KafkaProduct kafkaProducer) {
        this.kafkaProduct = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
    	this.kafkaProduct.sendMessage(message);
    	//this.kafkaProducer.sendMessage(message);
    }
}


