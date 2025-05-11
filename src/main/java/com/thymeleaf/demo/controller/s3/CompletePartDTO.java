package com.thymeleaf.demo.controller.s3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompletePartDTO {
  private int partNumber;
  private String eTag;
}
