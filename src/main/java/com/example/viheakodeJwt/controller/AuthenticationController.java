package com.example.viheakodeJwt.controller;

import com.example.viheakodeJwt.dto.request.LoginRequest;
import com.example.viheakodeJwt.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return authenticationService.verify(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
