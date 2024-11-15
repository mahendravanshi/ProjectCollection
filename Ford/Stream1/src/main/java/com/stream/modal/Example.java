package com.stream.modal;

public class Example {

    public static void main(String[] args) {
        Example obj = new Example();
        obj.printInts(1, 2, 3); // Call the method with int varargs explicitly
    }

    void printInts(int... numbers) {
        System.out.println("int varargs");
    }

    void printLongs(long... numbers) {
        System.out.println("long varargs");
    }
}
