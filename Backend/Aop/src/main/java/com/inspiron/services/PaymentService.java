package com.inspiron.services;

public interface PaymentService {
    void makePayment(int amount);
    Integer divideNumbers() throws Exception;

    Double proceedPayment(Double price);
}
