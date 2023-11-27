package com.example.demo.realgrid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.realgrid.dto.RealGridDto;
import com.example.demo.realgrid.mapper.RealGridMapper;

@Service
public class RealGridServiceImpl implements RealGridService {
    
    private final RealGridMapper RealGridMapper;
    
    public RealGridServiceImpl(RealGridMapper RealGridMapper) {
        this.RealGridMapper = RealGridMapper;
    }

    @Override
    public List<RealGridDto> getAlldata() {
        return RealGridMapper.getAlldata();
    }
}
