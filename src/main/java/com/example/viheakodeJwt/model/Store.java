package com.example.viheakodeJwt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tblStore")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String uuid;
    private String storeName;
    private String contactPhoneNumber;
    private String contactEmailAddress;
    private String address;
    private String profile;
    private String registrationNumber;
    private Date establishedDate;
    private Long userId;
    private String status;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;

    public Store() {
        this.status = "1";
        this.publisher = "admin";
        this.publishedDate = new Date(System.currentTimeMillis());
        this.modifiedDate = new Date(System.currentTimeMillis());
    }
}
