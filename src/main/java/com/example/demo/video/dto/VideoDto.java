package com.example.demo.video.dto;

import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.Setter;

public class VideoDto {

    @Getter @Setter
    private String title;

    @Getter @Setter
    private MultipartFile videoFile;
}