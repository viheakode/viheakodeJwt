package com.example.viheakodeJwt.service.serviceImp;

import com.example.viheakodeJwt.model.SubCategory;
import com.example.viheakodeJwt.repository.SubCategoryRepo;
import com.example.viheakodeJwt.service.ISubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SubCategoryServiceImp implements ISubCategoryService {

    @Autowired
    private SubCategoryRepo subCategoryRepo;

    @Override
    public SubCategory createNew(SubCategory subCategory) {
        subCategory.setUuid(UUID.randomUUID().toString());
        return subCategoryRepo.save(subCategory);
    }

    @Override
    public List<SubCategory> findAll() {
        return subCategoryRepo.findAll();
    }

    @Override
    public SubCategory findById(Long id) {
        return subCategoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("SubCategory not found"));
    }

    @Override
    public SubCategory updateById(Long id, SubCategory subCategory) {

        SubCategory curr = subCategoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("SubCategory not found"));

        curr.setSubCategoryName(subCategory.getSubCategoryName());
        curr.setDescription(subCategory.getDescription());
        curr.setCategoryId(subCategory.getCategoryId());
        curr.setModifiedDate(new Date(System.currentTimeMillis()));
        return subCategoryRepo.save(curr);
    }

    @Override
    public SubCategory deleteById(Long id) {
        SubCategory curr = subCategoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("SubCategory not found"));
        subCategoryRepo.deleteById(id);
        return curr;
    }
}
