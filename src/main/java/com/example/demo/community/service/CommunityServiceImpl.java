package com.example.demo.community.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.community.mapper.CommunityMapper;

@Service
public class CommunityServiceImpl implements CommunityService {
    
    private final CommunityMapper CommunityMapper;
    
    public CommunityServiceImpl(CommunityMapper CommunityMapper) {
        this.CommunityMapper = CommunityMapper;
    }

    public String inputUserInfo(Map<String, Object> userInfo) {
        try {
            CommunityMapper.insertUserInfo(userInfo);
            return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return "회원가입 오류발생";
        }
    }
}
