package com.unit_testing.Unit_testing.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public Integer login(String email, String password){
        if(email.isEmpty()){
            return 1;
        }else if(password.isEmpty()){
            return 2;
        } else if (email.equals("sushil") && password.equals("pass")) {
            return 3;
        }else {
            return 4;
        }
    }

    public String getUserName() {
        return UserService.getAccountName();
    }
}
