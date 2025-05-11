package com.thymeleaf.demo.controller.s3;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * DTO for the complete part of a multipart upload.
 * This class is used to encapsulate the data needed to complete a part of a multipart upload.
 */
public class CompletePartDTO {
  @JsonProperty("partNumber") // Ánh xạ trường JSON "partNumber" vào thuộc tính này
  private int partNumber;

  @JsonProperty("eTag") // Ánh xạ trường JSON "eTag" vào thuộc tính này
  private String eTag;
}
