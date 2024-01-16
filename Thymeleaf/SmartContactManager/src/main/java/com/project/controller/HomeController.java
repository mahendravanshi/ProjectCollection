package com.project.controller;

import com.project.entity.User;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @Autowired
    private UserRepository userRepository;


    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("title","This is Home of Contact Manager App");
        return "home";
    }



}