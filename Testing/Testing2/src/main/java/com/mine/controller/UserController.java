package com.mine.controller;

import com.mine.entity.User;
import com.mine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping(value = "/save")
    public User saveUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/getUserByAddress/{address}")
    public List<User> findUserByAddress(@PathVariable String address) {
        return service.findByAddress(address);
    }

    @DeleteMapping(value="/remove")
    public String removeUser(@RequestBody User user) {
       return service.deleteUser(user);

    }

    @GetMapping("get/{id}")
    public Optional<User> getById(@PathVariable Integer id){
        return Optional.ofNullable(service.findById(id));
    }





}
