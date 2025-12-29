package com.example.viheakodeJwt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tblProductImage")
@Data
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productImageId;
    private Long productId;
    private String image;
    private String status;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;
}
