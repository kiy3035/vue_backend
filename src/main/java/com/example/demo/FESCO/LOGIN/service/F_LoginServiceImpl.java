package com.example.demo.FESCO.LOGIN.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.FESCO.LOGIN.repository.F_LoginRepository;


@Service
public class F_LoginServiceImpl implements F_LoginService {
    
    @Autowired
    private F_LoginRepository loginRepository;
    
    public int checkLogin(Map<String, Object> data) {

        String usrCd = (String) data.get("username");
        String usrPw = (String) data.get("password");
    
        int result = loginRepository.countByUsrCdAndUsrPw(usrCd, usrPw);
        System.out.println("--------결과----------" + result);

        return result;
    }
    
}
