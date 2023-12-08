package com.example.demo.mypage.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.mypage.mapper.MypageMapper;

@Service
public class MypageServiceImpl implements MypageService {
    
    private final MypageMapper MypageMapper;
    
    public MypageServiceImpl(MypageMapper MypageMapper) {
        this.MypageMapper = MypageMapper;
    }

    public void updateUserInfo(Map<String, Object> userInfo, MultipartFile imageFile) {
        try {
            if (!userInfo.isEmpty()) {

                if (imageFile != null && !imageFile.isEmpty()) {

                    // 프로젝트 내부의 상대 경로 설정
                    String projectPath = System.getProperty("user.dir");
                    String relativePath = "uploads";
                    String uploadDirPath = projectPath + "/vue_front/src/assets/";

                    // 파일 저장 경로 설정
                    File uploadDir = new File(uploadDirPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdirs();
                    }

                    String newFileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();

                    imageFile.transferTo(new File(uploadDir, newFileName));
                    userInfo.put("imagePath", uploadDir.toString() + "/" + newFileName);
                }

                userInfo.put("updDate", new Date()); // SYSDATE 추가
                MypageMapper.updateUserInfo(userInfo);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
        public Map<String, Object> getUserImage(Map<String, Object> email) {
            System.out.println("=============:" + MypageMapper.getUserImg(email));
            return MypageMapper.getUserImg(email);
        }

}
