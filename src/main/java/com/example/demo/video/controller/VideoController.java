package com.example.demo.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.video.dto.VideoDto;
import com.example.demo.video.service.VideoService;

@RestController
// @CrossOrigin(origins = "http://localhost:8001")
// @RequestMapping("/api")
public class VideoController {
    
    @Autowired
    private VideoService videoService;

    @PostMapping("/api/upload")
    public String uploadVideo(@ModelAttribute VideoDto videoDto, @RequestParam("videoFile") MultipartFile videoFile) {
        // 업로드된 비디오 파일과 DTO를 서비스에 전달
        videoDto.setVideoFile(videoFile);
        String result = videoService.uploadVideo(videoDto, videoFile); // 데이터베이스에 비디오 정보를 저장하도록 수정
        if ("success".equals(result)) {
            return "업로드 되었습니다.";
        } else {
            return "업로드 실패 했습니다.";
        }
    }
}