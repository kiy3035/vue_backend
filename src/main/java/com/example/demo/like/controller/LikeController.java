package com.example.demo.like.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.like.dto.LikeDto;
import com.example.demo.like.service.*;
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
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8001", methods = { RequestMethod.POST })
public class LikeController {

    // @Autowired
    // private LikeService likeService;

    private int likeCount = 0;

    @PostMapping("/liked")
    public ResponseEntity<String> toggleLike(@RequestBody Map<String, String> requestData) {

        System.out.println("requestBody:@@@@@@@@@@" + requestData);

        // requestBody를 원하는 형태로 파싱하고 필요한 작업을 수행
        // 여기에서는 단순히 likeCount를 토글하는 것으로 가정
        likeCount = (likeCount == 0) ? 1 : 0;

        // 응답 데이터 생성
        Map<String, Integer> response = new HashMap<>();
        response.put("likeCount", likeCount);

        // ResponseEntity로 응답 반환
        return ResponseEntity.ok("gd하하");
    }
}
