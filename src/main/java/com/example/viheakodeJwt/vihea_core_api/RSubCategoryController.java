package com.example.viheakodeJwt.vihea_core_api;

import com.example.viheakodeJwt.dto.request.SubCategoryRequest;
import com.example.viheakodeJwt.model.SubCategory;
import com.example.viheakodeJwt.service.serviceImp.SubCategoryServiceImp;
import com.example.viheakodeJwt.util.UtilHelper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category/sub")
public class RSubCategoryController {

    @Autowired
    private SubCategoryServiceImp subCategoryServiceImp;

    @Autowired
    private UtilHelper utilHelper;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody SubCategoryRequest subCategoryRequest){

        SubCategory subCategory = new SubCategory();
        subCategory.setSubCategoryName(subCategoryRequest.getSubCategoryName());
        subCategory.setDescription(subCategoryRequest.getDescription());
        subCategory.setCategoryId(subCategoryRequest.getCategoryId());
        subCategory.setPublisher(utilHelper.getPublisher());
        subCategoryServiceImp.createNew(subCategory);
        return ApiResponseStructure.singleResponse("Created", subCategory, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        List<SubCategory> subCategoryList = subCategoryServiceImp.findAll();
        return ApiResponseStructure.singleResponse("Ok", subCategoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        SubCategory subCategory = subCategoryServiceImp.findById(id);
        return ApiResponseStructure.singleResponse("Ok", subCategory, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateById(@PathVariable Long id, @RequestBody SubCategoryRequest subCategoryRequest){
        SubCategory subCategory = subCategoryServiceImp.findById(id);
        subCategory.setSubCategoryName(subCategoryRequest.getSubCategoryName());
        subCategory.setDescription(subCategoryRequest.getDescription());
        subCategory.setCategoryId(subCategoryRequest.getCategoryId());
        subCategoryServiceImp.updateById(id, subCategory);
        return ApiResponseStructure.singleResponse("Updated", subCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        SubCategory subCategory = subCategoryServiceImp.findById(id);
        subCategoryServiceImp.deleteById(id);
        return ApiResponseStructure.singleResponse("Deleted", subCategory, HttpStatus.OK);
    }
}
