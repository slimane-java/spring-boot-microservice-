package com.example.demoServer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableKafka
public class DemoServer2Application {


	public static void main(String[] args) {
		SpringApplication.run(DemoServer2Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


}
