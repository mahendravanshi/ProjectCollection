package com.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Testing1ApplicationTests {

    @Autowired
    private Calculator calculator;


	@Test
	void contextLoads() {
	}

    //sum
    @Test
    void testSum(){

        int expectedResult = 6;

        //actual result
        int actualResult = calculator.doSum(1,2,3);

        assertThat(actualResult).isEqualTo(expectedResult);

    }

   //product
    @Test
    void testProduct(){

        int expected = 6;

        int res = calculator.doProduct(3,2);

        assertThat(res).isEqualTo(expected);
    }


    //compare
    @Test
    void testCompare(){


        Boolean res = calculator.compareNum(5,5);

        assertThat(res).isTrue();
    }




}
