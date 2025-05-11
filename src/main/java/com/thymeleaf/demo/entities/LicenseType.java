package com.thymeleaf.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "license_type")
public class LicenseType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "license_type_id")
  private Integer licenseTypeId;

  @Column(name = "license_name", nullable = false, length = 10)
  private String licenseName;

  @Column(name = "description")
  private String description;

}
