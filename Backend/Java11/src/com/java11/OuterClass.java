package com.java11;

public class OuterClass {
    public OuterClass() {
    }

    class InnerClass{
        public InnerClass() {
        }

        private void dc(){
            System.out.println("oc method created");
        }

        class InnerClass1{

            public InnerClass1() {



            }
        }

    }
}
