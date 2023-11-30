package com.example.demo.login.service;

import java.util.Map;

public interface LoginService {
    String inputUserInfo(Map<String, Object> userInfo);
    String login(Map<String, Object> userInfo);

    // List<LoginDto> getTitles();
    // Map<String, Object> getDatas(Map<String, Object> title);
}
