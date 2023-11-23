package com.example.demo.community.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityMapper {

    void insertUserInfo(Map<String, Object> data);

}