package com.example.demo.login.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.login.service.LoginService;


@RestController
// @CrossOrigin(origins = {"http://localhost:8001", "https://web-frontvue-57lz2alptar5jk.sel4.cloudtype.app" }) // 프론트엔드 포트
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 회원가입
    @PostMapping("/signup")
    public String singUp(@RequestBody Map<String, Object> data) {

        data.put("inpDate", new Date()); // SYSDATE 추가

        String result = loginService.inputUserInfo(data);

        return result;
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> data, HttpSession session) {

        String result = loginService.login(data);
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
