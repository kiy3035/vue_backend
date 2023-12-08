package com.example.demo.mypage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.mypage.service.MypageService;


@RestController
public class MypageController {

    @Autowired
    private MypageService MypageService;

    // 유저정보 수정
    @PostMapping("/updateUserInfo")
    public void UpdateUserInfo(@RequestPart("image") MultipartFile imageFile,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password) {
        
        System.out.println("Original Filename: " + imageFile.getOriginalFilename()); // 파일명
        System.out.println("Size: " + imageFile.getSize() + " bytes"); // 사이즈
        System.out.println("Content Type: " + imageFile.getContentType()); // 확장자

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("email", email);
        userInfo.put("password", password);
        userInfo.put("imageFile", imageFile);
        userInfo.put("imageFileName", imageFile.getOriginalFilename());

        MypageService.updateUserInfo(userInfo, imageFile);
    }


    // 유저 프사 들고오기
    @GetMapping("/getUserImage")
    public String GetUserImage(@RequestParam("email") String email) {
        
        System.out.println(email);
        
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("email", email);

        String imgPath = (String) MypageService.getUserImage(userInfo).get("IMG_PATH");

        return imgPath;
    }
    
}
