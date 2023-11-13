package com.example.demo.video.controller;
import java.util.Map;

// import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.video.dto.VideoDto;
import com.example.demo.video.service.VideoService;

@RestController
@CrossOrigin(origins = "http://localhost:8001")
// @RequestMapping("/api")
public class VideoController {
    
    @Autowired
    private VideoService videoService;

    @PostMapping("/api/upload")
    public String uploadVideo(@ModelAttribute VideoDto videoDto, @RequestParam("videoFile") MultipartFile videoFile) {
        // 업로드된 비디오 파일과 DTO를 서비스에 전달
        videoDto.setVideoFile(videoFile);
        videoService.uploadVideo(videoDto, videoFile);
        // videoService.uploadVideo(videoDto, videoFile);
        // videoService.uploadVideo(videoDto, videoFile); // MultipartFile을 인수로 전달
        return "fuck";
    }
}