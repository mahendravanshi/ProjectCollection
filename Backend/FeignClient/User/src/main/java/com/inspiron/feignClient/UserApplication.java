package com.inspiron.feignClient;

import com.inspiron.feignClient.ms.FeignCLientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.httpclient.HttpClientConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableFeignClients(clients = {com.inspiron.feignClient.ms.FeignCLientService.class})
//@EnableFeignClients("com.inspiron.ms")
//@ComponentScan(basePackages = {"com.inspiron.feignClient.ms","com.inspiron.feignClient","com.inspiron.feignClient.service"})
//@ImportAutoConfiguration({FeignAutoConfiguration.class})
@ImportAutoConfiguration({FeignAutoConfiguration.class, HttpClientConfiguration.class})

public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}



}
