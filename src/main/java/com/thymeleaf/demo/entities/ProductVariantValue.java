package com.thymeleaf.demo.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "product_variant_values")
public class ProductVariantValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "price")
    private Long price;

    @Column(name = "old_price")
    private Long oldPrice;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "sku", length = 11)
    private String sku;

    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Column(name = "update_at")
    @Temporal(TemporalType.DATE)
    private Date updateAt;

    // Getters and Setters
}
