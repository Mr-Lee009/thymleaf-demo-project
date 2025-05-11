package com.thymeleaf.demo.config.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {
//  @Bean
//  public S3Client s3Client(AwsS3Properties props) {
//    return S3Client.builder()
//        .region(Region.of(props.getRegion()))
//        .credentialsProvider(StaticCredentialsProvider.create(
//            AwsBasicCredentials.create(props.getAccessKey(), props.getSecretKey())
//        ))
//        .build();
//  }

  @Value("${aws.s3.accessKey}")
  private String accessKey;

  @Value("${aws.s3.secretKey}")
  private String secretKey;

  @Value("${aws.s3.region}")
  private String region;

  @Value("${aws.s3.bucket.name}")
  private String bucketName;

  @Bean
  public AmazonS3 amazonS3(){
    BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
    return AmazonS3ClientBuilder.standard()
        .withRegion(region)
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
        .build();
  }

}
