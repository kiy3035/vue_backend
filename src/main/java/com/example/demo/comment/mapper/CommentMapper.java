package com.example.demo.comment.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    void insertComment(Map<String, Object> data);
    List<Map<String, Object>> searchAllComments(Map<String, Object> data);
}