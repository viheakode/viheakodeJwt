package com.example.viheakodeJwt.vihea_core_api;

import com.example.viheakodeJwt.dto.request.StoreRequest;
import com.example.viheakodeJwt.model.Store;
import com.example.viheakodeJwt.service.serviceImp.StoreServiceImp;
import com.example.viheakodeJwt.utility.UtilHelper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/store")
public class RStoreController {

    @Autowired
    private StoreServiceImp storeServiceImp;

    @Autowired
    private UtilHelper utilHelper;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody StoreRequest storeRequest){

        Store store = new Store();
        store.setStoreName(storeRequest.getStoreName());
        store.setContactPhoneNumber(storeRequest.getContactPhoneNumber());
        store.setContactEmailAddress(storeRequest.getContactEmailAddress());
        store.setAddress(storeRequest.getAddress());
        store.setProfile(storeRequest.getProfile());
        store.setRegistrationNumber(storeRequest.getRegistrationNumber());
        store.setEstablishedDate(storeRequest.getEstablishedDate());
        store.setUserId(utilHelper.getUserId());
        store.setPublisher(utilHelper.getPublisher());
        storeServiceImp.createNew(store);
        return ApiResponseStructure.singleResponse("Created", store, HttpStatus.CREATED);


    }
}
