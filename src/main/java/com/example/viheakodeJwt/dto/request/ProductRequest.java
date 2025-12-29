package com.example.viheakodeJwt.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private String description;
    private Double price;
    private Double discount;
    private Long categoryId;
    private Long subCategoryId;
}
