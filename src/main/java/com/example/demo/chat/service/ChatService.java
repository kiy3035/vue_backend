package com.example.demo.chat.service;

import java.util.List;
import java.util.Map;

public interface ChatService {

    List<Map<String, Object>> getFriendsList();
    List<Map<String, Object>> getAllMessages(Map<String, Object> data);
    List<Map<String, Object>> getLastMessage(Map<String, Object> data);

}
