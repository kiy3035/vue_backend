package com.example.demo.chat.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.chat.service.ChatService;


@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    // 친구 목록
    @GetMapping("/getFriendsList")
    public List<Map<String, Object>> getFriendsList(@RequestBody Map<String, Object> data) {

        List<Map<String, Object>> result = chatService.getFriendsList(data);

        return result;
    }

    
}
