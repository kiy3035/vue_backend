package com.example.demo.comment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.comment.service.CommentService;


@RestController
// @CrossOrigin(origins = "http://localhost:8001")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글 입력
    @PostMapping("/inputComment")
    public String inputComment(@RequestBody Map<String, Object> data) {

        System.out.println("댓글맨:" + data);

        commentService.inputComment(data);
        
        return "OK";
    }

    // 댓글목록 가져오기
    @GetMapping("/getAllComments")
    public List<Map<String, Object>> getAllComments(@RequestParam Map<String, Object> data) {
        System.out.println("data보냄:" + data);
        return commentService.getAllComments(data);
    }

    // 댓글수 가져오기
    @GetMapping("/getCommentCount")
    public int getCommentCount(@RequestParam Map<String, Object> data) {
        return commentService.getCommentCount(data);
    }

    // 댓글 삭제
    @PostMapping("/deleteComment")
    public String deleteComment(@RequestBody Map<String, Object> data) {

        commentService.delComment(data);
        
        return "OK";
    }
}
