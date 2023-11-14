package com.example.demo.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.video.dto.VideoDto2;
import com.example.demo.video.service.VideoService2;

@RestController
// @CrossOrigin(origins = "http://localhost:8001")
// @RequestMapping("/api")
public class VideoController2 {
    
    @Autowired
    private VideoService2 videoService;

    @PostMapping("/api/upload")
    public String uploadVideo(@ModelAttribute VideoDto2 videoDto, @RequestParam("videoFile") MultipartFile videoFile) {
        // 업로드된 비디오 파일과 DTO를 서비스에 전달
        videoDto.setVideoFile(videoFile);
        videoService.uploadVideo(videoDto, videoFile);// MultipartFile을 인수로 전달
        return "success";
    }
}