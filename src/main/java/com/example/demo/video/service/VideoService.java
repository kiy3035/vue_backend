package com.example.demo.video.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.video.dto.VideoDto;

public interface VideoService {
    String uploadVideo(VideoDto videoDto, MultipartFile videoFile);
}
