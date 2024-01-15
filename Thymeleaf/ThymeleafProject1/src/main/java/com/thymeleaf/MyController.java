package com.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@Slf4j
public class MyController {

      @GetMapping("/textForm")
     public String addText(Model model){
           model.addAttribute("heading","Welcome to learning hub");
           model.addAttribute("name","Mahendra");
           model.addAttribute("this","Thymeleaf");

           return "text";
      }

      @GetMapping("/iterateLoop")
      public String iterationHandler(Model model){
//           create a list/set collection
//           th:each  can iterate different data types any iterable or collection.Also which implement map
//          it can traverse array
         List<String> names =  List.of("Mahendra","Surendra","Jitendra","Dharmendra");
          model.addAttribute("names",names);


          return "iterate";
      }

      //handler for conditional statements
     @GetMapping("/conditional")
     public String conditionalHandler(Model model){
          log.info("Conditional operator executed");

          model.addAttribute("isActive",true);
          model.addAttribute("gender","M");
          List<Integer> list = List.of(123,234,345,456,789);
          model.addAttribute("list",list);
          return "conditional";

     }


     //th:include fragments
    @GetMapping("/service")
    public String servicesHandler(Model model){
         model.addAttribute("title","Welcome to My Project");
         model.addAttribute("subTitle", LocalDate.now().toString());
          return "service";
    }


    // for new About
    @GetMapping("/newAbout")
    public String newAbout(){

          return "aboutnew";
    }


    // for new About
    @GetMapping("/contact")
    public String contact(){

        return "contact";
    }



}



// Elvis operator just like ternary operator
// condition ? "true" : "false";


// if - Unless   like if - else

