package com.example.demoServer1.dto;

import com.example.demoServer1.enums.InvoceEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDtoPost {
    private Long idClient;
    private Long idOrder;
    @Enumerated(EnumType.STRING)
    private InvoceEnum status;
}
