package com.example.viheakodeJwt.utility;

import com.example.viheakodeJwt.model.Store;
import com.example.viheakodeJwt.service.serviceImp.StoreServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilHelper {

    @Autowired
    private HttpSession session;

    @Autowired
    private StoreServiceImp storeServiceImp;

    public String getPublisher(){
        return (String) session.getAttribute("S_USERNAME");
    }

    public Long getUserId(){
        return (Long) session.getAttribute("S_USERID");
    }

    public Long getStoreId(){
        Store store = storeServiceImp.getByUserId(getUserId());
        return store.getStoreId();
    }
}
