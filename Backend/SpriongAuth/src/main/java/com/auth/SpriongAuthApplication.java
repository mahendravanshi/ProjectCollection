package com.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class SpriongAuthApplication {

//	@GetMapping("/oauth")
//	public String  welcomeController(Principal principal){
//
//		return "Welcome "+principal.getName()+" to the main page";
//	}
	public static void main(String[] args) {
		SpringApplication.run(SpriongAuthApplication.class, args);
	}





}
