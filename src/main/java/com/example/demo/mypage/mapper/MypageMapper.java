package com.example.demo.mypage.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.mypage.dto.MypageDto;

@Mapper
public interface MypageMapper {

    void updateUserInfo(Map<String, Object> data);
    // Map<String, Object> matchUserInfo(Map<String, Object> data);


}