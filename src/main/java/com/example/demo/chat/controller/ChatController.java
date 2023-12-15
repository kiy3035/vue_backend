package com.example.demo.chat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.chat.service.ChatService;


@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    // 친구목록 가져오기
    @GetMapping("/getFriendsList")
    public List<Map<String, Object>> getFriendsList() {
        return chatService.getFriendsList();
    }


    // 채팅기록 가져오기
    @GetMapping("/getAllMessages")
    public List<Map<String, Object>> getAllMessage(@RequestParam String myId, @RequestParam String otherId) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("myId", myId);
        paramMap.put("otherId", otherId);

        return chatService.getAllMessages(paramMap);
    }


    // 마지막 채팅 가져오기
    @GetMapping("/getLastMessage")
    public List<Map<String, Object>> getLastMessage(@RequestParam String myId) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("myId", myId);
        // paramMap.put("otherId", otherId);

        return chatService.getLastMessage(paramMap);
    }
   
}
