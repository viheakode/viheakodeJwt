package com.example.viheakodeJwt.vihea_core_api;

import com.example.viheakodeJwt.dto.request.CategoryRequest;
import com.example.viheakodeJwt.model.Category;
import com.example.viheakodeJwt.service.serviceImp.CategoryServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class RCategoryController {

    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CategoryRequest categoryRequest, HttpSession session){
        String publisher = (String) session.getAttribute("S_USERNAME");
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setDescription(categoryRequest.getDescription());
        category.setPublisher(publisher);
        categoryServiceImp.createNew(category);
        return ApiResponseStructure.singleResponse("Created", category, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAll(){
        List<Category> categoryList = categoryServiceImp.findAll();
        return ApiResponseStructure.singleResponse("Ok", categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        Category category = categoryServiceImp.findById(id);
        return ApiResponseStructure.singleResponse("Ok", category, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest){
        Category category = categoryServiceImp.findById(id);
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setDescription(categoryRequest.getDescription());
        categoryServiceImp.updateById(id, category);
        return ApiResponseStructure.singleResponse("Updated", category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        Category category = categoryServiceImp.findById(id);
        categoryServiceImp.deleteById(id);
        return ApiResponseStructure.singleResponse("Deleted", category, HttpStatus.OK);
    }
}
