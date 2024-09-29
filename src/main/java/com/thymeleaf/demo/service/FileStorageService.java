package com.thymeleaf.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileStorageService {
    //public static final String DIRECTORY = System.getProperty("user.home") + "\\spring-boot\\uploads";
    public static final String DIRECTORY = "D:\\Storage\\";

    public String saveFIle(MultipartFile file) throws IOException {
        System.out.println("DIRECTORY " + DIRECTORY);

        if (file == null)
            throw new NullPointerException("file is null");
        var target = new File(DIRECTORY + file.getOriginalFilename());
//        if (!Objects.equals(taget.getParent(), DIRECTORY)) {
//            throw new SecurityException("Unsupported fulename!");
//        }
        System.out.println("target : " + target.getPath());
        System.out.println("file : " + file.getOriginalFilename());

        Files.copy(file.getInputStream(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return file.getOriginalFilename() + " => upload success!";
    }

}
