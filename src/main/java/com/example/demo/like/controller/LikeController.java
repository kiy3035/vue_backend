package com.example.demo.like.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.like.service.LikeService;


@RestController
@CrossOrigin(origins = "http://localhost:8001", methods = { RequestMethod.POST })
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/like")
    public int toggleLike(@RequestBody Map<String, Object> data) {

        System.out.println("프론트에서 넘어온 값 : " + data);

        int likeCount = likeService.updateLike(data);
        System.out.println("반환할 값 :" + likeCount);
        return likeCount;
    }
    
    @PostMapping("/getLikedVideoList")
    public List<Map<String, Object>> getLikedList(@RequestBody Map<String, Object> data) {
        return likeService.getLikedVideoList(data);
    }

}
