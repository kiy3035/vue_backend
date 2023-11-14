package com.example.demo.video.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

public class VideoDto {

    @Getter @Setter
    private String title;
    @Getter @Setter
    private String path;
    @Getter @Setter
    private String type;
    @Getter @Setter
    private String video_no;
    @Getter @Setter
    private String inp_dt;

    @Getter @Setter
    private MultipartFile videoFile;
}