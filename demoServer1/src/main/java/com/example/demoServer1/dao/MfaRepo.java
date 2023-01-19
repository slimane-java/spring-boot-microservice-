package com.example.demoServer1.dao;

import com.example.demoServer1.entity.MfaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MfaRepo extends JpaRepository<MfaEntity, UUID> {
}
