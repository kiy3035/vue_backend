package com.example.demo.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.login.service.*;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origins = "http://localhost:8001") // 프론트엔드 포트
public class LoginController {

    @Autowired
    private LoginService LoginService;

    // 회원가입
    @PostMapping("/singUp")
    public String singUp(@RequestBody Map<String, Object> data) {

        data.put("inpDate", new Date()); // SYSDATE 추가

        String result = LoginService.inputUserInfo(data);

        return result;
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> data) {

        String result = LoginService.login(data);
        
        return result;
    }

    // @GetMapping("/signIn")
    // public List<dtoClass> getTitles() {
    //     List<dtoClass> titleList = LoginService.getTitles();
    //     System.out.println("getTitles:" + titleList);
    //     return titleList;
    // }
    
}
