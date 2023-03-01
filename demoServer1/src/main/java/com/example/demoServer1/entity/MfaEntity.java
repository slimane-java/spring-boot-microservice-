package com.example.demoServer1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MfaEntity {
    @Id
    private UUID tokenId;
    private String accessToken;
    private String username;
    private String value;
    private Instant instant;
}
