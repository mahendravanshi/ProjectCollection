package com.testing;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Testing1ApplicationTests {

    @Autowired
    private Calculator calculator;


    @BeforeAll
    public static void init(){
        System.out.println("This wil be executed before all tests");
    }

    @AfterAll
    public static void cleanup(){

        System.out.println("After all test cases");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("This will run before each test");
    }


    @AfterEach
    public void aftereach(){
        System.out.println("This will run after each test");
    }


    //sum
    @Test
    @DisplayName("customName of this Method")
    void testSum(){
        System.out.println("Test sum method");
        int expectedResult = 6;

        //actual result
        int actualResult = calculator.doSum(1,2,3);

        assertThat(actualResult).isEqualTo(expectedResult);

    }

   //product
    @Test
    void testProduct(){
        System.out.println("Test product");
        int expected = 6;

        int res = calculator.doProduct(3,2);

        assertThat(res).isEqualTo(expected);
    }


    //compare
    @Test
    void testCompare(){

        System.out.println("Terst Compare");
        Boolean res = calculator.compareNum(5,5);

        assertThat(res).isTrue();
    }


    //testAnyNum
    @Test

    void testAnySum(){
        System.out.println("Test any sum");
          int exp = 45;
          int n = calculator.addAnyNumbers(1,2,3,4,5,6,7,8,9,0);
        Assertions.assertEquals(exp,n,"Test failed ");
//          assertThat(n).isEqualTo(exp);
    }





}
