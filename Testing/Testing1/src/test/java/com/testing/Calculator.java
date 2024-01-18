package com.testing;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int doSum(int a,int b,int c){

        return a+b+c;
    }

    public int doProduct(int a,int b){
        return a*b;
    }

    public Boolean compareNum(int a,int b){
        return a==b;
    }

    public int addAnyNumbers(int ...nums){
         int x = 0;

        for(int n:nums){
           x+=n;
        }
        return x;
    }

}
