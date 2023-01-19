package com.example.demoServer1.service;

import com.example.demoServer1.dao.UserRepo;
import com.example.demoServer1.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserEntity create(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public List<UserEntity> all() {
        return userRepo.findAll();
    }
}
