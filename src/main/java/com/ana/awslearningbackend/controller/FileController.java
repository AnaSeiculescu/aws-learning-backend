package com.ana.awslearningbackend.controller;

import com.ana.awslearningbackend.service.S3Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    private final S3Service s3Service;

    public FileController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

        s3Service.uploadFile(
                file.getOriginalFilename(),
                file.getBytes()
        );

        return "File upload successfully";
    }
}
