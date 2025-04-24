package com.thymeleaf.demo.controller.s3;

import lombok.Data;

@Data
public class CompletePartDTO {
  private int partNumber;
  private String eTag;
}
