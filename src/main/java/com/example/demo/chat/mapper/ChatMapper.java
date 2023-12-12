package com.example.demo.chat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.chat.dto.ChatDto;

@Mapper
public interface ChatMapper {

    List<Map<String, Object>> getFriendsListByEmail(Map<String, Object> data);
    

}