package com.example.demo.mypage.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;


public interface MypageService {
    void updateUserInfo(Map<String, Object> userInfo, MultipartFile file);
    Map<String, Object> getUserImage(Map<String, Object> data);

}
