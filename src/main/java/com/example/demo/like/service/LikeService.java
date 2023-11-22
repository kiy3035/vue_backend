package com.example.demo.like.service;

import java.util.List;
import java.util.Map;

public interface LikeService {
    int updateLike(Map<String, Object> upLike);
    List<Map<String, Object>> getLikedVideoList(Map<String, Object> data);
}
