package com.example.demo.comment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.comment.service.CommentService;


@RestController
@CrossOrigin(origins = "http://localhost:8001")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/inputComment")
    public String inputComment(@RequestBody Map<String, Object> data) {

        System.out.println("댓글맨:" + data);

        commentService.inputComment(data);
        
        return "OK";
    }

    @GetMapping("/getAllComments")
    public List<Map<String, Object>> getAllComments() {

        return commentService.getAllComments();
    }

}
