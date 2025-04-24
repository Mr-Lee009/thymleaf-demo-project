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

@RestController
@RequestMapping("/api/upload/s3/")
public class S3MultipartUploadRestController {
  @Autowired
  private S3MultipartUploadService service;

  @PostMapping("/initiate")
  public Map<String, String> init(@RequestParam String filename) {
    String uploadId = service.initiateUpload(filename);
    System.out.printf("\nuploadId = %s", uploadId);
    return Map.of("uploadId", uploadId);
  }

  @GetMapping("/presigned-url")
  public Map<String, String> getUrl(@RequestParam String key, @RequestParam String uploadId,
      @RequestParam int partNumber) {
    System.out.printf("\nuploadId = %s ", uploadId);
    String url = service.generatePresignedPartUrl(key, uploadId, partNumber,15);
    System.out.printf("\nurl = %s", url);
    return Map.of("url", url);
  }

  @PostMapping("/complete")
  public void complete(@RequestBody CompleteUploadRequestDTO request) {
    service.completeUpload(request.getKey(), request.getUploadId(), request.getParts());
  }

  @DeleteMapping("/abort")
  public void abortUpload(@RequestParam String key, @RequestParam String uploadId) {
    service.abortUpload(key, uploadId);
  }
}
