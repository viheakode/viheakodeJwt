package com.example.viheakodeJwt.dto.request;

import lombok.Data;

@Data
public class SubCategoryRequest {
    private String subCategoryName;
    private String description;
    private Long categoryId;
}
