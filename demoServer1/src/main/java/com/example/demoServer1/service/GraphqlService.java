package com.example.demoServer1.service;

import com.example.demoServer1.dto.Query;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "graphql-server")
//@FeignClient(value = "graphql-server", url = "http://localhost:8060")
public interface GraphqlService {
    @PostMapping("/api-graphql-server/graphql")
    String allCustomer(@RequestBody Query query);

    @PostMapping(value = "/api-graphql-server/graphql", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> createCustomer(@RequestBody Query query);
}
