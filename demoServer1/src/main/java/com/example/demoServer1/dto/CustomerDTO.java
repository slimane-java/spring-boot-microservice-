package com.example.demoServer1.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String name;
    private String gender;
    private String mail;
    private String tel;
    private List<AccountDTO> accounts;

}
