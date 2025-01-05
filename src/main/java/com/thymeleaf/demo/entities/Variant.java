package com.thymeleaf.demo.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "variants")
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 256)
    private String productName = "product name";

    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Column(name = "update_at")
    @Temporal(TemporalType.DATE)
    private Date updateAt;

    // Getters and Setters
}
