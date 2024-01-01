package com.optum.lambdaExpresison;

public class Main {

    public static void main(String[] args) {
        A a  = new B();
        a.show();

        A a1 = new A(){

            public void show(){
                System.out.println("Inside anonymous inner class");
            }
        };


        a1.show();


        A a2 = ()-> System.out.println("Inside lambda expression");
        a2.show();


    }

}
