package com.inspiron.feignClient.userController;


import com.inspiron.feignClient.Entity.Order;
import com.inspiron.feignClient.Entity.User;
import com.inspiron.feignClient.ms.FeignCLientService;
import com.inspiron.feignClient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @Autowired
    private FeignCLientService feignCLientService;


    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){

        return new ResponseEntity<User>(userService.addUSer(user), HttpStatus.CREATED);
    }

    @GetMapping("/getOrder/{userId}")
    public ResponseEntity<List<Order>> getOrderByOrderId(@PathVariable Integer userId){

        return new ResponseEntity<>( feignCLientService.getallOrdersOfAUser(userId),HttpStatus.ACCEPTED);
    }








}
