package com.thymeleaf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/upload-file")
public class FileController {

    private static final String UPLOAD_DIRECTORY = "./files/";
    private final ConcurrentHashMap<String, Integer> uploadChucksMap = new ConcurrentHashMap<>();

    @GetMapping("/home")
    public String uploadPage() {
        return "uploadPage";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         @RequestParam("fileName") String fileName,
                         @RequestParam("chuckId") int chuckId,
                         @RequestParam("totalChuck") int totalChuck
    ) throws IOException {
        // Create directory if it's not exit
        Files.createDirectories(Paths.get(UPLOAD_DIRECTORY));

        //Save check to temp forder
        String checkFileName = UPLOAD_DIRECTORY + fileName + "." + chuckId;
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(checkFileName))) {
            outputStream.write(file.getBytes());
        }

        // save status chuck updated
        uploadChucksMap.merge(fileName, 1, Integer::sum);

        // check total chuck is uploaded
        if (uploadChucksMap.get(fileName) == totalChuck) {
            mergeChuck(fileName, totalChuck);
            uploadChucksMap.remove(fileName);
        }

        return "Chunk " + chuckId + " uploaded successfully";
    }

    private void mergeChuck(String fileName, int totalChuck) throws FileNotFoundException {
        String mergerFileName = UPLOAD_DIRECTORY + fileName;
        try (BufferedOutputStream mergerStream = new BufferedOutputStream(new FileOutputStream(mergerFileName))) {
            for (int i = 0; i < totalChuck; i++) {
                Path chuckPath = Paths.get(UPLOAD_DIRECTORY + fileName + "." + i);
                Files.copy(chuckPath, mergerStream);
                Files.delete(chuckPath);
            }
        } catch (IOException e) {
            System.out.println("MERGED CHUCK ERROR!");
        }
    }
}
