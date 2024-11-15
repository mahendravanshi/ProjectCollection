package com.unit_testing.Unit_testing.controller;

import com.unit_testing.Unit_testing.entity.User;
import com.unit_testing.Unit_testing.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {
    public final UserService userService;
    @PostMapping("/save")
    public ResponseEntity<User> saveHandler(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getAllUser(@PathVariable Integer id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    @PostMapping("/check/{fName}")
    public User check(@PathVariable String fName, @RequestParam String lName){
        User user = new User();
        user.setId(10);
        user.setName(fName);
        user.setEmail(lName);
        user.setMobile("0000");
        return user;
    }
}
