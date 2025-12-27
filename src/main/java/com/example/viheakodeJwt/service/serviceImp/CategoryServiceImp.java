package com.example.viheakodeJwt.service.serviceImp;

import com.example.viheakodeJwt.model.Category;
import com.example.viheakodeJwt.repository.CategoryRepo;
import com.example.viheakodeJwt.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImp implements ICategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category createNew(Category category) {
        category.setUuid(UUID.randomUUID().toString());
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
    }

    @Override
    public Category findByName(String name) {
        return null;
    }

    @Override
    public Category deleteById(Long id) {
        Category existed = categoryRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
        categoryRepo.deleteById(id);
        return existed;
    }

    @Override
    public Category updateById(Long id, Category category) {
        Category existed = categoryRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found"));
        existed.setCategoryName(category.getCategoryName());
        existed.setDescription(category.getDescription());
        existed.setModifiedDate(new Date(System.currentTimeMillis()));
        return categoryRepo.save(existed);
    }
}
