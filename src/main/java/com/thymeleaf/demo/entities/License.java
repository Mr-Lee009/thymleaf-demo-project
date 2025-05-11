package com.thymeleaf.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "license")
public class License {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "license_id")
  private Integer licenseId;

  @ManyToOne
  @JoinColumn(name = "candidate_id")
  private Candidate candidate;

  @ManyToOne
  @JoinColumn(name = "license_type_id")
  private LicenseType licenseType;

  @Column(name = "issue_date")
  @Temporal(TemporalType.DATE)
  private Date issueDate;

  @Column(name = "expiry_date")
  @Temporal(TemporalType.DATE)
  private Date expiryDate;

}
