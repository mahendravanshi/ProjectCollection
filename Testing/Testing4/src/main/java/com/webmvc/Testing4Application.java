package com.webmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Testing4Application {

	public static void main(String[] args) {

		SpringApplication.run(Testing4Application.class, args);
	}


//	@Bean
//	public ObjectMapper getMapper(){
//		return new ObjectMapper();
//	}


}
