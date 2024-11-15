package com.fordTest1.DesignPatterns.creational.builder;

public class Main {

    public static void main(String[] args) {
        URLBuilder urlBuilder = new URLBuilder.Builder("https","www.example.com").port("8080")
                .path("name").query("name=xyz").build();


        URLBuilder urlBuilder1 = URLBuilder.builder("https","www.example.com").port("8080")
                .path("name").query("name=xyz").build();

        System.out.println(urlBuilder);
        System.out.println(urlBuilder1);

    }
}
