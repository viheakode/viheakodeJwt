package com.example.viheakodeJwt.repository;

import com.example.viheakodeJwt.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {
    Store findByUserId(Long userId);
}
