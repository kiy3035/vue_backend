package com.example.demo.chat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper {

    List<Map<String, Object>> getFriendsList();
    void insertMessage(Map<String, Object> data);
    Integer findChatRoomYN(Map<String, Object> data);
    Integer findMaxChatRoomID(Map<String, Object> data);
    List<Map<String, Object>> findAllMessages(Map<String, Object> data);
    List<Map<String, Object>> findLastMessage(Map<String, Object> data);


}