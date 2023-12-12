package com.example.demo.chat.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.chat.mapper.ChatMapper;

@Service
public class ChatServiceImpl implements ChatService {
    
    private final ChatMapper chatMapper;
    
    public ChatServiceImpl(ChatMapper ChatMapper) {
        this.chatMapper = ChatMapper;
    }

    public List<Map<String, Object>> getFriendsList(Map<String, Object> userInfo) {
        try {
            if (!userInfo.isEmpty()) {
                chatMapper.getFriendsListByEmail(userInfo);
            }
            return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
