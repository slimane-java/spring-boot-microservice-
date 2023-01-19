package com.example.demoServer1.entity;

import com.example.demoServer1.enums.InvoceEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idClient;
    private Long idOrder;
    @Enumerated(EnumType.STRING)
    private InvoceEnum status;
    private float priceTotal;


}
