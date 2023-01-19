package com.example.demoServer1.service;

import com.example.demoServer1.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity create(UserEntity user);
    List<UserEntity> all();
}
