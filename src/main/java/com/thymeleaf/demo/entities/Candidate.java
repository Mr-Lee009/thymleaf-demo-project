package com.thymeleaf.demo.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "candidate")
public class Candidate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "candidate_id")
  private Integer candidateId;

  @Column(name = "full_name", nullable = false, length = 100)
  private String fullName;

  @Column(name = "birth_date")
  @Temporal(TemporalType.DATE)
  private Date birthDate;

  @Column(name = "national_id", length = 20)
  private String nationalId;

  @Column(name = "address")
  private String address;

  @Column(name = "phone", length = 15)
  private String phone;

  @Column(name = "email", length = 100)
  private String email;

  @Column(name = "registration_date")
  private LocalDateTime registrationDate = LocalDateTime.now();

}


