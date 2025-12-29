package com.example.viheakodeJwt.vihea_core_api;

import com.example.viheakodeJwt.dto.request.ProductRequest;
import com.example.viheakodeJwt.model.Product;
import com.example.viheakodeJwt.service.serviceImp.ProductServiceImp;
import com.example.viheakodeJwt.utility.UtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class RProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

    @Autowired
    private UtilHelper utilHelper;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody ProductRequest productRequest){
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setDiscount(productRequest.getDiscount());
        product.setCategoryId(productRequest.getCategoryId());
        product.setSubCategoryId(productRequest.getSubCategoryId());
        product.setStoreId(utilHelper.getStoreId());
        product.setUserId(utilHelper.getUserId());
        productServiceImp.createNew(product);
        return ApiResponseStructure.singleResponse("Created", product, HttpStatus.CREATED);

    }
}
