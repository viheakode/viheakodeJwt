package com.example.viheakodeJwt.util;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilHelper {

    @Autowired
    private HttpSession session;

    public String getPublisher(){
        Object username = session.getAttribute("S_USERNAME");
        return username != null ? username.toString() : null;
    }
}
