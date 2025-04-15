package com.thymeleaf.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "question_id")
  private Integer questionId;

  @Column(name = "exam_type", length = 20)
  private String examType;

  @Lob
  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "image_path")
  private String imagePath;

  @Column(name = "correct_answer", length = 1)
  private String correctAnswer;

}
