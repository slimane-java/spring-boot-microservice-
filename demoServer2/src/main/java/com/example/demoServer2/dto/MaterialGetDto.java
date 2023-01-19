package com.example.demoServer2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialGetDto implements Serializable {
    private static final long serialVersionUID = 4439114469417994311L;

    private Long id;
    private String string;
    private float price;
}
