package com.ford.fordScenario.controller;

import com.ford.fordScenario.model.User;
import com.ford.fordScenario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

      @Autowired
      private UserService userService;


      @PostMapping
      public ResponseEntity<User> registerUser(@RequestBody User user)  {
          return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);

      }

       @GetMapping
      public ResponseEntity<User> findById(UUID anyInt) {
            return new ResponseEntity<>(userService.findById(anyInt), HttpStatus.CREATED);
      }


}
