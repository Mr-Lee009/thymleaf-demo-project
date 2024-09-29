package com.thymeleaf.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UploadForm {
    private MultipartFile cccdMt;
    private MultipartFile cccdMs;
    private String name;
    private String phoneNumber;

    @Override
    public String toString() {
        return "UploadForm{" +
                "cccdMt=" + (cccdMt!=null ? cccdMt.getOriginalFilename() : "") +
                ", cccdMs=" + (cccdMs!=null ? cccdMs.getOriginalFilename() : "") +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
