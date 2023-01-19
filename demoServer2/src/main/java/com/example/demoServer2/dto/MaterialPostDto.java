package com.example.demoServer2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialPostDto implements Serializable {
    private static final long serialVersionUID = 4439114469417994311L;

    private Long id;
    private String string;
    private Date dateBuy;
    private Date dateRun;
    private float price;
    private String code;
}
