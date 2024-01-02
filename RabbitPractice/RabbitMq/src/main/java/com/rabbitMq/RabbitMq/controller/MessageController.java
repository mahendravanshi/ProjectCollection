package com.rabbitMq.RabbitMq.controller;


import com.rabbitMq.RabbitMq.publisher.RabbitMQProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MessageController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

//    "/api/v1/publish"
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){

        rabbitMQProducer.sendMessage(message);
        log.info("Received request to send message: {}", message);
        return new ResponseEntity<>("Response sent to RabbitMQ "+message, HttpStatus.OK
        );
    }
}
