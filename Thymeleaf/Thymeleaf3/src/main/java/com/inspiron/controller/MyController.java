package com.inspiron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

      @GetMapping("/example")
      public String example(){

          return "example";

      }


}
