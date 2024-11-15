package com.stream.singleton;

import javax.crypto.Cipher;

public class Main {

    public static void main(String[] args) {

        Clipboard clipboard1 = Clipboard.getInstance();
        Clipboard clipboard2 = Clipboard.getInstance();

        clipboard2.copy("React");
        clipboard1.copy("SpringBoot");


        System.out.println(clipboard1.paste());
        System.out.println(clipboard2.paste());

    }
}
