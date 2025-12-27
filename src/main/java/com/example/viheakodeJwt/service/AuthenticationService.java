package com.example.viheakodeJwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MoyJwtService moyJwtService;

    public String verify(String username, String password){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        if (authentication.isAuthenticated()){
            return moyJwtService.generateToken(username);
        }
        return "Authenticate failed";
    }
}
