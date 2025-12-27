package com.example.viheakodeJwt.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String email;
    private String password;
}
