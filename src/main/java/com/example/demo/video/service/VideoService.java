package com.example.demo.video.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.video.dto.VideoDto;

public interface VideoService {
    List<VideoDto> getAllVideos();
    String uploadVideo(VideoDto videoDto, MultipartFile videoFile);
}
