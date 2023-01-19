package com.example.demoServer2.service;

import com.example.demoServer2.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaterialServiceDelegated {

    private final RestTemplate restTemplate;
    //@HystrixCommand(fallbackMethod = "getAllUserData_FallBack")
    public List<UserDto> getAllUserData() {

        UserDto[] userDtos1 = restTemplate.getForObject("http://localhost:8060/api-projectTest/client/all", UserDto[].class);

        assert userDtos1 != null;

        Arrays.stream(userDtos1).collect(Collectors.toList()).forEach(userDto -> {
            System.out.println(userDto.getEmail());
        });

        return Arrays.stream(userDtos1).collect(Collectors.toList());
    }

    //@SuppressWarnings("unused")
    public String getAllUserData_FallBack(){
        return "CIRCUIT BREAKER ENABLED!!!";
    }


}
