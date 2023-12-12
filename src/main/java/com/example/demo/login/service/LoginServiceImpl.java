package com.example.demo.login.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.login.mapper.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {
    
    private final LoginMapper loginMapper;
    
    public LoginServiceImpl(LoginMapper LoginMapper) {
        this.loginMapper = LoginMapper;
    }

    public String inputUserInfo(Map<String, Object> userInfo) {
        try {
            if (!userInfo.isEmpty()) {
                // 회원가입시 중복email 방지하는 로직 만들것(미완성)
                loginMapper.insertUserInfo(userInfo);
            }
            return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return "회원가입 오류발생";
        }
    }
    

    public String login(Map<String, Object> userInfo) {
        
        if (!userInfo.isEmpty()) {
            Map<String, Object> result = loginMapper.matchUserInfo(userInfo);
            System.out.println("결과값: " + result);

            if(result == null){
                return null;
            }
            return (String) result.get("EMAIL");
        }
        return null;
    }


}
