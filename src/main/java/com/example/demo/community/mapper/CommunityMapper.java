package com.example.demo.community.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.community.dto.CommunityDto;

@Mapper
public interface CommunityMapper {

    void insertCommunity(Map<String, Object> data);
    void updateCommunity(Map<String, Object> data);
    void deleteCommunity(Map<String, Object> data);

    @Select("SELECT * FROM VUE_COMMUNITY ORDER BY INP_DT DESC")
    List<CommunityDto> getAlldata();

    @Select("SELECT NICKNAME FROM VUE_USERINFO WHERE EMAIL = #{email}")
    List<CommunityDto> getNickname(@Param("email") String email);

}