package com.example.demo.like.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {

    void upLike(Map<String, Object> data);
    void insertLike_YN(Map<String, Object> data);
    int getLikeCount(Map<String, Object> data);
    List<Map<String, Object>> getDupLike(Map<String, Object> data);

}