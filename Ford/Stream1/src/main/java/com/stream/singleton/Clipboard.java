package com.stream.singleton;

import java.awt.datatransfer.ClipboardOwner;

public class Clipboard {

      private String value;
      private static Clipboard clipboard = null;


      public static Clipboard getInstance(){
          if(clipboard==null){
              clipboard = new Clipboard();
          }

          return clipboard;
      }

      public void copy(String value){
          this.value = value;
      }

      public String paste(){
          return value;
      }


}
