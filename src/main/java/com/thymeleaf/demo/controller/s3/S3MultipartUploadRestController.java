package com.thymeleaf.demo.controller.s3;

import com.thymeleaf.demo.service.S3MultipartUploadService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/upload/s3/")
public class S3MultipartUploadRestController {
  @Autowired
  private S3MultipartUploadService service;

  @PostMapping("/initiate")
  public Map<String, String> init(@RequestParam(name = "filename") String filename) {
    String uploadId = service.initiateUpload(filename);
    System.out.printf("\n[initiate]uploadId = %s", uploadId);
    return Map.of("uploadId", uploadId);
  }

  @GetMapping("/presigned-url")
  public Map<String, String> getUrl(@RequestParam(name = "key") String key, @RequestParam(name = "uploadId") String uploadId,
      @RequestParam(name = "partNumber") int partNumber) {
    System.out.printf("\n[presigned-url]uploadId = %s ", uploadId);
    String url = service.generatePresignedPartUrl(key, uploadId, partNumber,15);
    System.out.printf("\n[presigned-url]url = %s", url);
    return Map.of("url", url);
  }

  @PostMapping("/complete")
  public String complete(@RequestBody CompleteUploadRequestDTO request) {
    try {
      System.out.printf("\n[complete]request = %s", request);
      System.out.printf("\n[complete]request.getParts() = %s", request.getParts());
      System.out.printf("\n[complete]request.getKey() = %s", request.getKey());
      System.out.printf("\n[complete]request.getUploadId() = %s", request.getUploadId());
      String urlFIle = service.completeUpload(request.getKey(), request.getUploadId(), request.getParts());
      return Objects.nonNull(urlFIle) ? urlFIle : "Upload failed";
    } catch (Exception e) {
      // TODO: handle exception
      return "Upload failed : error = " + e.getMessage();
    }
  }

  @DeleteMapping("/abort")
  public void abortUpload(@RequestParam(name = "key") String key, @RequestParam(name = "uploadId") String uploadId) {
    service.abortUpload(key, uploadId);
  }
}
