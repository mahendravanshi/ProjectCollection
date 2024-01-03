package com.rabbitMq.RabbitMq.publisher;


import com.rabbitMq.RabbitMq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonProducer {

    @Value("{rabbitmq.exchange.name}")
    private String exchange;

    @Value("{rabbitmq.routing.json.key}")
    private String jsonKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user){
        log.info("inside json sendJsonMessage:{}",user);
        rabbitTemplate.convertAndSend(exchange,jsonKey,user);

    }



}
