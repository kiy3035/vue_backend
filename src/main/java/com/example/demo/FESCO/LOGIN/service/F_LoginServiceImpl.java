package com.example.demo.FESCO.LOGIN.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.community.dto.CommunityDto;
import com.example.demo.community.mapper.CommunityMapper;

@Service
public class F_LoginServiceImpl implements F_LoginService {
    
    private final CommunityMapper CommunityMapper;
    
    public F_LoginServiceImpl(CommunityMapper CommunityMapper) {
        this.CommunityMapper = CommunityMapper;
    }

    public String insertCommunity(Map<String, Object> insertCommunity) {
        try {
            CommunityMapper.insertCommunity(insertCommunity);
            return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return "오류발생!!";
        }
    }
    
}
