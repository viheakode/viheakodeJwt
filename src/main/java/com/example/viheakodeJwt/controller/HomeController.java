package com.example.viheakodeJwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping
    public ResponseEntity<Object> home(){
        Map<String, Object> stringStringMap = new HashMap<>();
        stringStringMap.put("success", true);
        stringStringMap.put("message", "App is running");
        stringStringMap.put("status", HttpStatus.OK);
        return ResponseEntity.ok().body(stringStringMap);
    }
}
