package com.thymeleaf.demo.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "variant_values")
public class VariantValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "variant_id")
    private Long variantId;

    @Column(name = "value", length = 1024)
    private String value = "variant values";

    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Column(name = "update_at")
    @Temporal(TemporalType.DATE)
    private Date updateAt;

    // Getters and Setters
}
