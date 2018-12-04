package com.example.security.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "\"User\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private Boolean enabled;

    @Column
    private Boolean accountExpired;

    @Column
    private Boolean accountLocked;

    @Column
    private Boolean credentialsExpired;

    @Column
    private Date lastLogin;


}
