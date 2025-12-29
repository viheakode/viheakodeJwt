package com.example.viheakodeJwt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tblProductReview")
@Data
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productReviewId;
    private String uuid;
    private Long productId;
    private String comment;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;
}
