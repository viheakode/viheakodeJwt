package com.example.viheakodeJwt.vihea_core_api;

import com.example.viheakodeJwt.dto.request.UserRequest;
import com.example.viheakodeJwt.model.User;
import com.example.viheakodeJwt.service.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class RUserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody UserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getPassword());
        user.setPassword(userRequest.getPassword());
        userServiceImp.createNew(user);
        return ApiResponseStructure.singleResponse("Created", user, HttpStatus.CREATED);
    }
}
