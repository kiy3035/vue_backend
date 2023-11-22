package com.example.demo.video.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

public class VideoDto {

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String content;

    @Getter @Setter
    private String user_name;

    @Getter @Setter
    private String user_nickname;

    @Getter @Setter
    private String path;

    @Getter @Setter
    private String type;

    @Getter @Setter
    private String video_id;

    @Getter @Setter
    private String inp_dt;

    @Getter @Setter
    private int like_count;

    @Getter @Setter
    private int comment_count;

    @Getter @Setter
    private MultipartFile videoFile;

    public void setFilename(String videoId) {
    }
}