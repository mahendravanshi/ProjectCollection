package com.hysterix.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/cb")
@Slf4j
public class CircuitController {

    @Autowired
    private RestTemplate restTemplate;

    // Specify a unique name for the circuit breaker
//    private static final String CIRCUIT_BREAKER_NAME = "myCircuitBreaker";


    @GetMapping("/bookNow")
    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "alternateMethod")
    public String bookShow() {
        log.info("Attempting to check mail...");
        String email = restTemplate.getForObject("http://localhost:9191/email/send", String.class);
        log.info("Attempting to book a show...");
        String noti = restTemplate.getForObject("http://localhost:8181/notification/send", String.class);
        log.info("Show Booked");
        return email + "\n" + noti;
    }
    public String alternateMethod(Exception e) {
        log.info("Alternate method called due to circuit breaker: {}", e.getMessage());
        return e.getMessage();
    }

    @GetMapping("bookNowWithoutHystrix")
    public String bookShowWithoutHystrix() {
        log.info("Calling logger method without hystrix");
        String email = restTemplate.getForObject("http://localhost:9191/email/send", String.class);
        String noti = restTemplate.getForObject("http://localhost:8181/notification/send", String.class);
        log.info("Called logger method without hystrix");
        return email + "\n" + noti;
    }

}


