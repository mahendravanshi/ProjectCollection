package com.rabbitMq.RabbitMq.controller;

import com.rabbitMq.RabbitMq.dto.User;
import com.rabbitMq.RabbitMq.publisher.RabbitMQJsonProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class MeessageJsonController {

    @Autowired
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/jsonPublish")
    public ResponseEntity<User> sendJsonMessage(@RequestBody User user){
        log.info("user: {}",user);
        rabbitMQJsonProducer.sendJsonMessage(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
