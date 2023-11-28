package com.example.demo.realgrid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.realgrid.dto.RealGridDto;
import com.example.demo.realgrid.service.RealGridService;


@RestController
@CrossOrigin(origins = "http://localhost:8001") // 프론트엔드 포트
public class RealGridController {

    @Autowired
    private RealGridService RealGridService;

    @GetMapping("/searchTest")
    @ResponseBody
    public List<RealGridDto> searchData() {
        return RealGridService.getAllDataDto();
    }
}
