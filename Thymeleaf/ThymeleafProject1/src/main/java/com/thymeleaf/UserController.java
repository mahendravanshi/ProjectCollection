package com.thymeleaf;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Slf4j
@Controller
public class UserController {

    @GetMapping("/inputForm")
    public String showInputForm(Model model) {
        model.addAttribute("userInputForm", new UserInputForm());
        return "inputForm";

    }


    @PostMapping("/processInput")
    public String processInput(@ModelAttribute UserInputForm userInputForm, Model model) {
        // Process the data (e.g., save to a database)
        System.out.println("Username: " + userInputForm.getUsername());
        System.out.println("Password: " + userInputForm.getPassword());
        System.out.println("Flag: " + userInputForm.isFlag());

        // Redirect to another page and pass the form object
        model.addAttribute("userDetails", userInputForm);
        // Process the data (e.g., save to a database)
        System.out.println("Processing input form: " + userInputForm);

        System.out.println("Redirecting to result page.");
        return "result";

    }


    @GetMapping("/result")
    public String showResult(@ModelAttribute("userDetails") UserInputForm userInputForm) {
        // Access user details from the redirected model attribute
        // You can use userInputForm.getUsername(), userInputForm.getPassword(), etc.
        log.info("User input form :{}",userInputForm);
        return "result";
    }





}
