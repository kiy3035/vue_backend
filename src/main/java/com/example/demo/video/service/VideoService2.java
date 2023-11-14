package com.example.demo.video.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.video.dto.VideoDto2;

public interface VideoService2 {
    void uploadVideo(VideoDto2 videoDto, MultipartFile videoFile);
}
