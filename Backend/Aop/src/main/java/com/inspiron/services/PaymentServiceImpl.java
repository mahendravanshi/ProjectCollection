package com.inspiron.services;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void makePayment(int amount) {

        System.out.println(amount+" credited");
        System.out.println(amount+" debited");

    }

    @Override
    public Integer divideNumbers() throws Exception {
         int x = 1;
         int y = 1/x;
         if(x==0){
             throw new Exception("Cannot divide by zero");
         }
         else{
             return y;
         }

    }

    @Override
    public Double proceedPayment(Double price) {
        return price;
    }


}
