package com.ms.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic topic() {
		
		return TopicBuilder.name(AppConstants.location_topic)
//				.partitions(4)
//				.replicas(2)
				.build();
		
	}
}
