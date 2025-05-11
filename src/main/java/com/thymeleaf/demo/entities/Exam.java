package com.thymeleaf.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "exam")
public class Exam {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "exam_id")
  private Integer examId;

  @ManyToOne
  @JoinColumn(name = "candidate_id")
  private Candidate candidate;

  @ManyToOne
  @JoinColumn(name = "exam_session_id")
  private ExamSession examSession;

  @ManyToOne
  @JoinColumn(name = "license_type_id")
  private LicenseType licenseType;

  @Column(name = "exam_datetime")
  private LocalDateTime examDatetime = LocalDateTime.now();

  @Column(name = "score", precision = 5)
  private Double score;

  @Column(name = "result", length = 10)
  private String result;

}
