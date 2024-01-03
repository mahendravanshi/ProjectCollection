package com.rabbitMq.RabbitMq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String myQueue;

    @Value("${rabbitmq.exchange.name}")
    private String myExchange;

    @Value("${rabbitmq.routing.key}")
    private String myKey;

    //json
    @Value("${rabbitmq.queue.json.name}")
    private String json_queue;

    @Value("${rabbitmq.routing.json.key}")
    private String json_key;



    // spring bean for queue to store messages
    @Bean
    public Queue queue() {
        log.info("inside queue()");
        return new Queue(myQueue);
    }

    //spring bean for queue(json_queue) to store messages
    @Bean
    public Queue jsonQueue(){
        return new Queue(json_queue);
    }


    // spring bean for rabbit exchange
    @Bean
    public TopicExchange exchange() {
        log.info("inside exchange()");
        return new TopicExchange(myExchange);
    }

    // binding between queue and exchange using routing key
    @Bean
    public Binding binding() {
        log.info("inside binding()");
        return BindingBuilder.bind(queue()).to(exchange()).with(myKey);
    }

    // binding between json queue and json exchange using routing key
    @Bean
    public Binding jsonBinding(){
        log.info("inside json_binding");
        return BindingBuilder.bind(jsonQueue()).to(exchange()).with(json_key);
    }


    // Spring Boot will autoconfigure these beans
    // Connection factory, Rabbit Template, Rabbit Admin

    //create json convertor so that rabbitmq can support json messages
    @Bean
    public MessageConverter converter(){

        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate= new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    
}


