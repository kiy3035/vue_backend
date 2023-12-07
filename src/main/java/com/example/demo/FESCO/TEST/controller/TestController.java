package com.example.demo.FESCO.TEST.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FESCO.TEST.entity.TestMstEntity;
import com.example.demo.FESCO.TEST.repository.TestRepository;


@RestController
// @CrossOrigin(origins = "http://localhost:8001")
@RequestMapping("/FESCO")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    // 조인테스트
    @PostMapping("/joinTest")
    public List<TestMstEntity> JoinTest(@RequestBody Map<String, Object> data) {
        
        String arapNo = (String) data.get("arapNo");

        System.out.println("@@@@@@@@@@@@@@@@@@@@:" + testRepository.findByArapNo(arapNo));
        return testRepository.findByArapNo(arapNo);
    }

    
}
