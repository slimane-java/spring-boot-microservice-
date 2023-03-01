package com.example.demoServer2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material implements Serializable {
    private static final long serialVersionUID = 4439114469417994311L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String string;
    private Date dateBuy;
    private Date dateRun;
    private float price;
    private String code;
    private String codePromo;

}
