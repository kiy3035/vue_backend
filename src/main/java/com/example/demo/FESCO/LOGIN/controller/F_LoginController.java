package com.example.demo.FESCO.LOGIN.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FESCO.LOGIN.service.F_LoginService;


@RestController
// @CrossOrigin(origins = "http://localhost:8001")
@RequestMapping("/FESCO")
public class F_LoginController {

    @Autowired
    private F_LoginService loginService;

    // 로그인
    @PostMapping("/login")
    public int checkLogin(@RequestBody Map<String, Object> data) {
        
        System.out.println("fesco 넘어온 값:" + data);

        return loginService.checkLogin(data);
    }

    
}
