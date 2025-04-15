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

  @OneToMany(mappedBy = "candidate")
  private List<Exam> exams;

  @OneToMany(mappedBy = "candidate")
  private List<License> licenses;

  public Candidate() {
  }

  public Integer getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(Integer candidateId) {
    this.candidateId = candidateId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getNationalId() {
    return nationalId;
  }

  public void setNationalId(String nationalId) {
    this.nationalId = nationalId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }

  public List<Exam> getExams() {
    return exams;
  }

  public void setExams(List<Exam> exams) {
    this.exams = exams;
  }

  public List<License> getLicenses() {
    return licenses;
  }

  public void setLicenses(List<License> licenses) {
    this.licenses = licenses;
  }
}


