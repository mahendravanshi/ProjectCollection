package com.fordTest1.TDDTesting1.lambda;

import java.util.function.*;

public class FunctionalInterfaces {


    public static void main(String[] args) {

          Runnable runnable = new Runnable(){

                @Override
                public void run(){
                    System.out.println("Start ");
                }
          };

          runnable.run();

          Runnable runnable1 = ()-> {
              System.out.println("ok");
              System.out.println("ok2");
          };

          runnable1.run();


        System.out.println("=====================Function=========================");


        Function<Integer,Double> addDouble = a-> (Double) (a*2.0);

        System.out.println(addDouble.apply(2));

        System.out.println("=====================Function=========================");

        System.out.println("=====================BiFunction=========================");


        BiFunction<Integer,Integer,Double> addDouble1 = (a,b)-> (Double) (a*2.0*b);

        System.out.println(addDouble1.apply(2,2));

        System.out.println("=====================BiFunction=========================");


        System.out.println("=====================Predicate=========================");


        Predicate<Integer>  checkEven = a->a%2==0;

        System.out.println("IS no even "+checkEven.test(5));

        System.out.println("=====================Predicate=========================");

        System.out.println("=====================BiPredicate=========================");


        BiPredicate<Integer,Integer> checkSumGreaterThan5 = (a,b)-> (a+b)>5;

        System.out.println(checkSumGreaterThan5.test(2,3));

        System.out.println("=====================BiPredicate=========================");


        System.out.println("=====================Consumer=========================");

        Consumer<Integer> cons = a-> System.out.println(a);

        cons.accept(10);

        System.out.println("=====================Consumer=========================");
        System.out.println("=====================BiConsumer=========================");

        BiConsumer<Integer,Integer> bicons = (a,b)-> System.out.println(a+b);

        bicons.accept(10,2);

        System.out.println("=====================BiConsumer=========================");

        System.out.println("=====================Unary=========================");

        UnaryOperator<Integer> un = a-> a*a;

        System.out.println( un.apply(10));

        UnaryOperator<String> un1 = a-> "My name is "+a;

        System.out.println(un1.apply("Mahendra"));;


        System.out.println("=====================Unary== when input and output types are same=======================");

        System.out.println("=====================Binary Operator=========================");

        BinaryOperator<Integer> bo = (a,b)-> (a+b);

        System.out.println(bo.apply(3,5));


        System.out.println("=====================Binary Operator=========================");



    }


}
