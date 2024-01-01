package com.inspiron.controller;


import com.inspiron.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/process-payment")
    public String processPayment(@RequestParam Integer amount) {
        paymentService.makePayment(amount);
        return "Payment processed successfully";
    }

    @GetMapping("/throw")
    public String throwException() throws Exception {

        paymentService.divideNumbers();
        return "Exception thrown or something returned";
    }

    @GetMapping("/proceed")
    public Double getProceed(@RequestParam Double price){
       return paymentService.proceedPayment(price);
    }



}

