package com.example.demoServer1.api;

import com.example.demoServer1.entity.UserEntity;
import com.example.demoServer1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity user){
        System.out.println("user" + user.getPassword());
        return ResponseEntity.ok().body(userService.create(user));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> all(){
        return ResponseEntity.ok().body(userService.all());
    }

}
