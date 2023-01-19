package com.example.demoServer1.entityTarget;

import com.example.demoServer1.enumsTarget.RolesEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientGetDto {

    private Long id;
	private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String username;
    private List<RolesEnum> rolesEntities;

}
