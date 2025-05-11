package com.thymeleaf.demo.controller.s3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload-multiple")
public class S3MultipartUploadController {
  @GetMapping("")
  public String index(){
    return "s3UploadPage";
  }

  
}
