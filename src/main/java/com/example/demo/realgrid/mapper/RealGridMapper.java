package com.example.demo.realgrid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.realgrid.dto.RealGridDto;

@Mapper
public interface RealGridMapper {

    @Select("SELECT * FROM VUE_USERINFO")
    List<RealGridDto> getAlldata();

}