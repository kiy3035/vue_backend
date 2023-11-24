package com.example.demo.community.service;

import java.util.List;
import java.util.Map;

import com.example.demo.community.dto.CommunityDto;

public interface CommunityService {
    String inputUserInfo(Map<String, Object> userInfo);
    List<CommunityDto> getAlldata();
    // List<LoginDto> getTitles();
    // Map<String, Object> getDatas(Map<String, Object> title);
    
}
