package com.example.sbkafkaproducer.controller;

import com.example.sbkafkaproducer.kafka.JsonKafkaProducer;
import com.example.sbkafkaproducer.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishJSON (@RequestBody  User user){
        kafkaProducer.sentdMessege(user);
        return ResponseEntity.ok("JSON Message send to Kafka topic");
    }
}
