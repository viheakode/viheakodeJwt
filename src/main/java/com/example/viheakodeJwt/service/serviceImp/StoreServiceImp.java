package com.example.viheakodeJwt.service.serviceImp;

import com.example.viheakodeJwt.model.Store;
import com.example.viheakodeJwt.repository.StoreRepo;
import com.example.viheakodeJwt.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StoreServiceImp implements IStoreService {

    @Autowired
    private StoreRepo storeRepo;

    @Override
    public Store createNew(Store store) {
        store.setUuid(UUID.randomUUID().toString());
        return storeRepo.save(store);
    }

    @Override
    public Store getByUserId(Long userId) {
        return storeRepo.findByUserId(userId);
    }
}
