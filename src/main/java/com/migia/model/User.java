package com.migia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    private String username;

    private String password;


    private String firstname;

    private String lastname;

    private String Department;

    private String email;

    private String phoneNumber;

    private String universityRegistrationNumber;

    private boolean isActive;

    private Role role;



}
