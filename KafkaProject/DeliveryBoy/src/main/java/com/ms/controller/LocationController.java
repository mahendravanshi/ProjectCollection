package com.ms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private KafkaService kafkaService;
	
	public static int times = 20;
	
	@PostMapping("/update")
	public ResponseEntity<Map<String, String>> updateLocation(){
		for(int i=1;i<=10;i++){
			this.kafkaService.updateLocation("working"+times++);
		}

		return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
	}
}
