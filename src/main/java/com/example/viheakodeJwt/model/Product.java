package com.example.viheakodeJwt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tblProduct")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String uuid;
    private String productName;
    private String description;
    private Double price;
    private Double discount;
    private Long categoryId;
    private Long subCategoryId;
    private Long storeId;
    private Long userId;
    private String status;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;

    public Product() {
        this.status = "1";
        this.publisher = "admin";
        this.publishedDate = new Date(System.currentTimeMillis());
        this.modifiedDate = new Date(System.currentTimeMillis());
    }
}
