package com.example.demo.community.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.community.service.CommunityService;
import com.example.demo.community.dto.CommunityDto;


@RestController
@CrossOrigin(origins = "http://localhost:8001") // 프론트엔드 포트
public class CommunityController {

    @Autowired
    private CommunityService CommunityService;

    // 글쓰기
    @PostMapping("/write")
    public String singUp(@RequestBody Map<String, Object> data) {

        data.put("inp_dt", new Date()); // SYSDATE 추가

        String result = CommunityService.inputUserInfo(data);

        return result;
    }

    @GetMapping("/communitySearch")
    @ResponseBody
    public List<CommunityDto> searchData() {
        return CommunityService.getAlldata();
    }
    // 로그인한 사용자의 이메일 가져오기
    // @GetMapping("/getuseremail")
    // public ResponseEntity<String> getUserEmail(HttpSession session) {

    //     String userEmail = (String) session.getAttribute("email");

    //     if (userEmail != null) {
    //         return new ResponseEntity<>(userEmail, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    //     }
    // }
    
}
