package com.thymeleaf.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "exam_session")
public class ExamSession {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "exam_session_id")
  private Integer examSessionId;

  @Column(name = "exam_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date examDate;

  @Column(name = "start_time")
  @Temporal(TemporalType.TIME)
  private Date startTime;

  @Column(name = "end_time")
  @Temporal(TemporalType.TIME)
  private Date endTime;

  @Column(name = "venue")
  private String venue;

  @Column(name = "exam_type", length = 20)
  private String examType;

}
