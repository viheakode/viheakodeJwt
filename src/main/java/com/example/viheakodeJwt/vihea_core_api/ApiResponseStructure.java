package com.example.viheakodeJwt.vihea_core_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiResponseStructure {

    public static ResponseEntity<Object> singleResponse(String msg, Object object, HttpStatus httpStatus){
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("message", msg);
        objectMap.put("data", object);
        objectMap.put("statusCode", httpStatus);
        return new ResponseEntity<>(objectMap, httpStatus);
    }
}
