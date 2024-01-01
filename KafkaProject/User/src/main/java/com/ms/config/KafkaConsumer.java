package com.ms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumer {

	
	@KafkaListener(topics = AppConstant.updats,groupId =AppConstant.groupId)
	public void updatedLocation(String value) {
		System.out.println(value);
	}


}
