package com.example.viheakodeJwt.service;

import com.example.viheakodeJwt.model.SubCategory;

import java.util.List;

public interface ISubCategoryService {
    SubCategory createNew(SubCategory subCategory);
    List<SubCategory> findAll();
    SubCategory findById(Long id);
    SubCategory updateById(Long id, SubCategory subCategory);
    SubCategory deleteById(Long id);
}
