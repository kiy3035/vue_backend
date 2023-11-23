package com.example.demo.comment.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.comment.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
    
    private final CommentMapper commentMapper;
    
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public void inputComment(Map<String, Object> data) {
        try {
            System.out.println("@@@@@@@@@@@@@@@@@@@@" + data);
            if (!data.isEmpty()) {
                commentMapper.insertComment(data);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> getAllComments() {
        return commentMapper.searchAllComments();
    }

}
