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
@Table(name = "candidate_answer")
public class CandidateAnswer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "candidate_answer_id")
  private Integer candidateAnswerId;

  @ManyToOne
  @JoinColumn(name = "exam_id")
  private Exam exam;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private Question question;

  @ManyToOne
  @JoinColumn(name = "answer_choice_id")
  private AnswerChoice answerChoice;

  @Column(name = "answer_time")
  private LocalDateTime answerTime = LocalDateTime.now();

}
