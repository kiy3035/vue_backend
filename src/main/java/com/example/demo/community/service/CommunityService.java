package com.example.demo.community.service;

import java.util.List;
import java.util.Map;

import com.example.demo.community.dto.CommunityDto;

public interface CommunityService {
    String insertCommunity(Map<String, Object> community);
    String updateCommunity(Map<String, Object> community);
    String deleteCommunity(Map<String, Object> community);
    List<CommunityDto> getAlldata();
    List<CommunityDto> getNickname(String email);
    // List<LoginDto> getTitles();
    // Map<String, Object> getDatas(Map<String, Object> title);
    
}
