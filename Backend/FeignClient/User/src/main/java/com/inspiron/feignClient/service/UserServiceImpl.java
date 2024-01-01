package com.inspiron.feignClient.service;


import com.inspiron.feignClient.Entity.Order;
import com.inspiron.feignClient.Entity.User;

import com.inspiron.feignClient.ms.FeignCLientService;

import com.inspiron.feignClient.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;



    @Override
    public User addUSer(User user){
        User u = userRepo.save(user);
        return u;
    }




}

