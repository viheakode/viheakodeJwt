package com.example.viheakodeJwt.service.serviceImp;

import com.example.viheakodeJwt.model.Product;
import com.example.viheakodeJwt.repository.ProductRepo;
import com.example.viheakodeJwt.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product createNew(Product product) {
        product.setUuid(UUID.randomUUID().toString());
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }
}
