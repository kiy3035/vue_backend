package com.example.demo.video.mapper;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.example.demo.video.dto.VideoDto;

public interface VideoMapper {
    void insertVideo(VideoDto videoDto);

    LinkedHashMap<String, Object> searchVideo(HashMap<String, Object> parameters);
}
