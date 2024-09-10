package com.example.fileuploading.controller;

import com.example.fileuploading.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper helper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        System.out.println(file.getContentType());
//        System.out.println(file.getName());
        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only ");
            }

            //file upload code...
            boolean uploaded=helper.uploadFile(file);
            if(uploaded){
                return ResponseEntity.ok("File is successfully uploaded");
            }
            else{

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong ! Try again");
    }
}
