package com.thymeleaf.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "answer_choice")
public class AnswerChoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "answer_choice_id")
  private Integer answerChoiceId;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private Question question;

  @Column(name = "label", nullable = false, length = 1)
  private String label;

  @Lob
  @Column(name = "content", nullable = false)
  private String content;
}
