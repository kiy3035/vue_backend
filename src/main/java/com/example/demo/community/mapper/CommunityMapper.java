package com.example.demo.community.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.community.dto.CommunityDto;

@Mapper
public interface CommunityMapper {

    void insertUserInfo(Map<String, Object> data);

    @Select("SELECT * FROM VUE_COMMUNITY ORDER BY INP_DT DESC")
    List<CommunityDto> getAlldata();

}