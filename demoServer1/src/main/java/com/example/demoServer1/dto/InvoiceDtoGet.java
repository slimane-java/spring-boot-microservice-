package com.example.demoServer1.dto;

import com.example.demoServer1.enums.InvoceEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDtoGet {
    private Long id;
    private Long idClient;
    private Long idOrder;
    @Enumerated(EnumType.STRING)
    private InvoceEnum status;
    private float priceTotal;
}
