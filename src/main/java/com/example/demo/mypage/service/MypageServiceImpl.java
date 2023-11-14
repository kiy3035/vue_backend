package com.example.demo.mypage.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.mypage.dto.MypageDto;
import com.example.demo.mypage.mapper.MypageMapper;

@Service
public class MypageServiceImpl implements MypageService {
    
    private final MypageMapper MypageMapper;
    
    public MypageServiceImpl(MypageMapper MypageMapper) {
        this.MypageMapper = MypageMapper;
    }

    public void updateUserInfo(Map<String, Object> userInfo) {
        try {
            if (!userInfo.isEmpty()) {
                MypageMapper.updateUserInfo(userInfo);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    // public String login(Map<String, Object> userInfo) {
        
    //     if (!userInfo.isEmpty()) {
    //         Map<String, Object> result = MypageMapper.matchUserInfo(userInfo);
    //         System.out.println("결과값: " + result);

    //         if(result == null){
    //             return null;
    //         }
    //         return (String) result.get("EMAIL");
    //     }
    //     return null;
    // }


}
