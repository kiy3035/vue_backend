package com.example.demo.FESCO.LOGIN.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.FescoConnMapper;

@Mapper
@FescoConnMapper
public interface F_LoginMapper {

    int loginCheck(Map<String, Object> data);
}