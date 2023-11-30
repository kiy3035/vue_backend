package com.example.demo.FESCO.LOGIN.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.FESCO.LOGIN.mapper.F_LoginMapper;

@Service
public class F_LoginServiceImpl implements F_LoginService {
    
    private final F_LoginMapper loginMapper;
    
    public F_LoginServiceImpl(F_LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public int checkLogin(Map<String, Object> data) {

        loginMapper.loginCheck(data);

        return 1;
    }
    
}
