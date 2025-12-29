package com.example.viheakodeJwt.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class StoreRequest {
    private String storeName;
    private String contactPhoneNumber;
    private String contactEmailAddress;
    private String address;
    private String profile;
    private String registrationNumber;
    private Date establishedDate;
}
