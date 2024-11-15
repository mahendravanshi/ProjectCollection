package com.unit_testing.Unit_testing.controller;

import com.unit_testing.Unit_testing.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password){
        Integer isLogin = loginService.login(email, password);
        if(isLogin == 3){
            return loginService.getUserName();
        }else{
            return String.valueOf(isLogin);
        }
    }

}
