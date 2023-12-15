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

    // 친구목록 들고오기
    public List<Map<String, Object>> getFriendsList() {
        return chatMapper.getFriendsList();
    }


    // 모든 메세지 다 들고오기
    public List<Map<String, Object>> getAllMessages(Map<String, Object> data) {
        try {
            if (!data.isEmpty()) {
                return chatMapper.findAllMessages(data);
            }
                return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // 젤 최근 메세지 들고오기
    public List<Map<String, Object>> getLastMessage(Map<String, Object> data) {
        try {
            if (!data.isEmpty()) {
                List<Map<String, Object>> newData = chatMapper.findLastMessage(data);

                for(int i = 0; i < newData.size(); i++){

                    String value = (String) newData.get(i).get("IMG_PATH");
            
                    // assets/ 뒷부분만 추출해서 화면에 넘겨줘야함
                    String extractedPath = value.substring(value.indexOf("assets/") + "assets/".length());

                    newData.get(i).put("IMG_PATH", extractedPath);
                }
                return newData;
            }
                return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
