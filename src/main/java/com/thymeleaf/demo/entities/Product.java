package com.thymeleaf.demo.entities;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, length = 1024)
    private String productName = "product name";

    @Column(name = "image", length = 1024)
    private String image = "default-image.jpg";

    @Column(name = "decription", length = 1024)
    private String description;

    @Column(name = "price")
    private Long price = 0L;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "rating")
    private Long rating = 0L;

    @Column(name = "create_at", updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "update_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "brand_id")
    private Long brandId;

    // Getters and Setters
}

