package com.project.controller;

import com.project.entity.User;
import com.project.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class HomeController {


    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","This is Home of Contact Manager App");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title","This is About Page of Contact Manager App");
        return "about";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title","Register - Smart Contact Manager");
        model.addAttribute("user",new User());
        return "signup";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("title","Login - Smart Contact Manager");
        return "login";
    }


//    this handler is for regsitering user

    @PostMapping("/do_register")
    public String registetUser(@ModelAttribute("user")User user,@RequestParam(value = "agreement",defaultValue = "false") Boolean agreement,Model model){


        if(!agreement){
            System.out.println("You have not agreed to t&c");
        }

        user.setRole("ROLE_USER");
        user.setEnabled(true);


        log.info("Agreement ",agreement);
        log.info("User:{}",user);

       User res =  userRepository.save(user);

        model.addAttribute("USER",res);
        return "signup";

     }



}
