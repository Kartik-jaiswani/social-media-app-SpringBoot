package com.instagram.blog.socialmediaapp.controller;

import com.instagram.blog.socialmediaapp.payload.FileResponse;
import com.instagram.blog.socialmediaapp.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class FileController {

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/image/upload")
    ResponseEntity<FileResponse> fileUpload(@RequestParam("image")MultipartFile image){
        String fileName = null;
        try {
            fileName = this.fileService.uploadImage(path,image);
        } catch (IOException e) {
            return new ResponseEntity<FileResponse>(new FileResponse(null,"Image Upload Failed"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<FileResponse>(new FileResponse(fileName,"Image was uploaded Successfully"), HttpStatus.OK);
    }
}
