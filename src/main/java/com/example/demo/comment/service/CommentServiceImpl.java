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
                commentMapper.commentCountPlus1(data);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> getAllComments(Map<String, Object> data) {
        return commentMapper.searchAllComments(data);
    }

    public int getCommentCount(Map<String, Object> data) {
        return commentMapper.getCommentCount(data);
    }

    public void delComment(Map<String, Object> data) {
        commentMapper.commentCountMinus1(data);
        commentMapper.deleteComment(data);
    }

}
