package com.example.demo.mypage.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {

    void updateUserInfo(Map<String, Object> data);
    Map<String, Object> getUserImg(Map<String, Object> data);

}