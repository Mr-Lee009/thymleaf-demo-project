package com.thymeleaf.demo.controller.s3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * DTO for the complete upload request.
 * This class is used to encapsulate the data needed to complete a multipart upload.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompleteUploadRequestDTO {
  private String key;
  private String uploadId;
  private List<CompletePartDTO> parts;


}
