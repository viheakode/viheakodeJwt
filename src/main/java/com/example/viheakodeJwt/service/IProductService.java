package com.example.viheakodeJwt.service;

import com.example.viheakodeJwt.model.Product;

import java.util.List;

public interface IProductService {
    Product createNew(Product product);
    List<Product> getAll();
}
