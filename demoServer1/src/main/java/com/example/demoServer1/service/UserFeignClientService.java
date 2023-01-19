package com.example.demoServer1.service;

import com.example.demoServer1.entityTarget.ClientGetDto;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "project-test",url = "http://localhost:8060/api-demo-service-support")

public interface UserFeignClientService {
    @GetMapping(value = "/materials/all")
    List<ClientGetDto> getAllClientTest();


}
