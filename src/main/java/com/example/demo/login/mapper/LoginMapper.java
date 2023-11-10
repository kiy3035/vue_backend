package com.example.demo.login.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.dto.LoginDto;

@Mapper
public interface LoginMapper {

    void insertUserInfo(Map<String, Object> data);
    Map<String, Object> matchUserInfo(Map<String, Object> data);
    
    // List<LoginMapper> selectTitles();
    // List<Map<String, Object>> selectDatas(String title);

}