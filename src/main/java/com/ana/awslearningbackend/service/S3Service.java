package com.ana.awslearningbackend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;


@Service
public class S3Service {

    private final S3Client s3Client;
    private final String bucketName;

    public S3Service(
            S3Client s3Client,
            @Value("${aws.s3.bucket-name}") String bucketName) {

        this.s3Client = s3Client;
        this.bucketName = bucketName;
    }

    public void uploadFile(String fileName, byte[] fileContent) {

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();

        s3Client.putObject(
                request,
                RequestBody.fromBytes(fileContent)
        );
    }
}
