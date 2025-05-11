package com.thymeleaf.demo.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.PartETag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thymeleaf.demo.controller.s3.CompletePartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class S3MultipartUploadService {

  @Autowired
  private AmazonS3 s3Client;

  @Value("${aws.s3.bucket.name}")
  private String bucketName;

  /**
   * Initiates a multipart upload session for a given S3 object key (filename)
   *
   * @param key
   * @return Upload ID - Returns an Upload ID which is used to upload multiple
   *         parts.
   */
  public String initiateUpload(String key) {
    System.out.println("1__________________initiateUpload" + key);
    InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(bucketName, key);
    InitiateMultipartUploadResult result = s3Client.initiateMultipartUpload(request);
    String uploadId = result.getUploadId();
    System.out.println("2__________________initiateUpload" + uploadId);
    return uploadId;
  }

  /**
   * Generates a basic upload URL for a specific part. This version simply returns
   * the raw object
   * URL with partNumber and uploadId appended. Note: this is not a true
   * pre-signed URL and might
   * not work if S3 is private.
   *
   * @param key
   * @param uploadId
   * @param partNumber
   * @return
   */
  public String generatePresignedPartUrl(String key, String uploadId, int partNumber,
      int expirationMinutes) {
    Date expiration = new Date(System.currentTimeMillis() + expirationMinutes * 60 * 1000);
    GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, key).withMethod(HttpMethod.PUT)
        .withExpiration(expiration);
    request.addRequestParameter("uploadId", uploadId);
    request.addRequestParameter("partNumber", String.valueOf(partNumber));

    URL url = s3Client.generatePresignedUrl(request);
    return url.toString();
  }

  /**
   * Completes a multipart upload after all parts are uploaded. Requires the list
   * of parts (with
   * partNumber and eTag from S3).
   *
   * @param key
   * @param uploadId
   * @param parts
   */
  public String completeUpload(String key, String uploadId, List<CompletePartDTO> parts) throws Exception {

    List<PartETag> partETags = parts.stream().map(p -> new PartETag(p.getPartNumber(), p.getETag()))
        .collect(Collectors.toList());

    // Complete the multipart upload
    CompleteMultipartUploadRequest completeRequest = new CompleteMultipartUploadRequest();
    completeRequest.setBucketName(bucketName);
    completeRequest.setKey(key);
    completeRequest.setUploadId(uploadId);
    completeRequest.setPartETags(partETags);

    s3Client.completeMultipartUpload(completeRequest);

    // Lấy URL của object sau khi upload thành công
    String objectUrl = s3Client.getUrl(bucketName, key).toString();
    System.out.println("Upload completed. Object URL: " + objectUrl);

    // Trả về URL
    return objectUrl;
  }

  /**
   * Aborts a multipart upload if needed (e.g. on client cancel or error).
   * Prevents orphaned parts
   * from being stored in S3 and billed.
   */
  public void abortUpload(String key, String uploadId) {
    s3Client.abortMultipartUpload(new AbortMultipartUploadRequest(bucketName, key, uploadId));
  }

  // get link after upload success
  public String getLink(String key) {
    return s3Client.getUrl(bucketName, key).toString();
  }
}
