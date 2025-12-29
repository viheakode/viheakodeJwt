package com.example.viheakodeJwt.service;

import com.example.viheakodeJwt.model.Store;

public interface IStoreService {
    Store createNew(Store store);
    Store getByUserId(Long userId);
}
