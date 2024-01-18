package com.testing;

import org.junit.jupiter.api.Assertions;

public class AssertExample {

//      Assertions
    public void test1(){

        System.out.println("Testing assertions");

        int actual = 12;
        int expected = 12;

        Assertions.assertEquals(expected,actual);

        boolean value = true;
        Assertions.assertTrue(value);
    }
}
