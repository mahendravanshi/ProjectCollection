package com.optum.garbageCollector;

public class TestGarbage {



    protected void finalize(){
        System.out.println("Garbage finalize() method is called");
    }

    public static void main(String[] args) {

        TestGarbage tg1 = new TestGarbage();
        TestGarbage tg2 = new TestGarbage();
        TestGarbage tg3 = new TestGarbage();

        tg1 = null;
        tg2 = null;
        System.gc();

    }
}
