package com.thymeleaf.demo.restcontroller;

import com.thymeleaf.demo.dto.UploadForm;
import com.thymeleaf.demo.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/file")
public class FileRestController {

    @Autowired
    FileStorageService fileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestBody MultipartFile file) {
        return "success!";
    }

    @PostMapping("/upload-form")
    public String uploadInfoUser(@ModelAttribute UploadForm formInfo) {
        System.out.println(formInfo.getCccdMs().getOriginalFilename());
        System.out.println(formInfo.getCccdMt().getOriginalFilename());
        System.out.println(formInfo.getPhoneNumber());
        System.out.println(formInfo.getName());

        return formInfo.toString();
    }

    @PostMapping("/upload-files")
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        List<String> fileNames = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                String filename = fileService.saveFIle(file);
                fileNames.add(filename);
            } catch (IOException e) {
                System.out.println("Error when save file " + file.getOriginalFilename()
                        + "\nMessage: " + e.getMessage());
            }
        }
        return ResponseEntity.ok(fileNames);
    }
}
