package com.example.viheakodeJwt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tblUser")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String uuid;
    private String username;
    private String email;
    private String password;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;

    public User() {
        this.publisher = "admin";
        this.publishedDate = new Date(System.currentTimeMillis());
        this.modifiedDate = new Date(System.currentTimeMillis());
    }
}
