package com.example.viheakodeJwt.service;

import com.example.viheakodeJwt.model.Category;

import java.util.List;

public interface ICategoryService {
    Category createNew(Category category);
    List<Category> findAll();
    Category findById(Long id);
    Category findByName(String name);
    Category deleteById(Long id);
    Category updateById(Long id, Category category);

}
