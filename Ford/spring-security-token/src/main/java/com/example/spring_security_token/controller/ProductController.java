package com.example.spring_security_token.controller;

import com.example.spring_security_token.dto.AuthRequest;
import com.example.spring_security_token.dto.Product;
import com.example.spring_security_token.entity.UserInfo;
import com.example.spring_security_token.service.JwtService;
import com.example.spring_security_token.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public String addNewUser(@Valid @RequestBody UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return service.addUser(userInfo);
    }





    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public List<Product> getAllTheProducts() {
        return service.getProducts();
    }


    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }


    @PostMapping("/generateToken")
    public String authenticateAndGettoken(@RequestBody AuthRequest authRequest){
       Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(),authRequest.password()));
       if(authentication.isAuthenticated()){
           return jwtService.generateToken(authRequest.username());

       }
       else{
           throw new UsernameNotFoundException("Invalid User Request");
       }

    }



}
