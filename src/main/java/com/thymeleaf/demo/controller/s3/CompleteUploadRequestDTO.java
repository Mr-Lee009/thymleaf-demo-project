package com.thymeleaf.demo.controller.s3;

import lombok.Data;

import java.util.List;

@Data
public class CompleteUploadRequestDTO {
  private String key;
  private String uploadId;
  private List<CompletePartDTO> parts;
}
