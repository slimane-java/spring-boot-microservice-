package com.example.demoServer2.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private static final long serialVersionUID = 4439114456417994311L;
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String username;
}
