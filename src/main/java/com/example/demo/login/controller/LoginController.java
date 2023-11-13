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

import javax.servlet.http.HttpSession;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origins = "http://localhost:8001") // 프론트엔드 포트
public class LoginController {

    @Autowired
    private LoginService LoginService;

    // 회원가입
    @PostMapping("/signup")
    public String singUp(@RequestBody Map<String, Object> data) {

        data.put("inpDate", new Date()); // SYSDATE 추가

        String result = LoginService.inputUserInfo(data);

        return result;
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> data, HttpSession session) {

        String result = LoginService.login(data);
        System.out.println("result ::::" + result);

        if (result != null) {
            return result;
        }else{
            return "로그인 실패";
        }
    }

    // 로그인한 사용자의 이메일 가져오기
    @GetMapping("/getuseremail")
    public ResponseEntity<String> getUserEmail(HttpSession session) {

        String userEmail = (String) session.getAttribute("email");

        if (userEmail != null) {
            return new ResponseEntity<>(userEmail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    
}
