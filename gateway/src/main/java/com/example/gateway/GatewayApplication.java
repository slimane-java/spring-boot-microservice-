package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@Configuration

public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

//	@Bean
//	public RouteLocator configureRoute(RouteLocatorBuilder builder){
//		return builder.routes()
////				.route("demo-service", r -> r.path("/api-invoice/**").uri("http://localhost:8089/")).build();
//				.route("demo-service", r -> r.path("/api-invoice/**").uri("")).build();
//	}

/*	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		System.out.println("i'm here ");
		return builder.routes().route(routeLocator -> routeLocator.path("/api-invoice/**").uri("lb://DEMO-SERVICE/") ).build();
	}*/

}
