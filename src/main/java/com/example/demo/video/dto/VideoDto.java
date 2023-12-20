package com.example.demo.video.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoDto {

    private String title;

    private String content;

    private String user_email;

    private String user_name;

    private String user_nickname;

    private String path;

    private String type;

    private String video_id;

    private String inp_dt;

    private int like_count;

    private int comment_count;

    private MultipartFile videoFile;

    private String video_url;

    private String category;

    public void setFilename(String videoId) {
    }
}