package com.example.demo.comment.service;

import java.util.List;
import java.util.Map;

public interface CommentService {
    
    void inputComment(Map<String, Object> data);
    List<Map<String, Object>> getAllComments(Map<String, Object> data);
    int getCommentCount(Map<String, Object> data);
    void delComment(Map<String, Object> data);

}
