package com.example.viheakodeJwt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tblProductFavorite")
@Data
public class ProductFavorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productFavoriteId;
    private String uuid;
    private Long productId;
    private String favorite;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;
}
