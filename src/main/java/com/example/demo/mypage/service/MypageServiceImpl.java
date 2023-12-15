package com.example.demo.mypage.service;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

                    // 프로젝트 내부의 상대 경로 설정(vue_front에 저장되도록 함)
                    String projectPath = System.getProperty("user.dir");
                    System.out.println("projectPath:" + projectPath);
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

            System.out.println("이사람 프사:" + MypageMapper.getUserImg(email));
            Map<String, Object> result = MypageMapper.getUserImg(email);
            Map<String, Object> defaultImage = new HashMap<>();
            defaultImage.put("IMG_PATH", "ad512187-963c-4987-a5dc-f2cbf29d9332_기본프사.png");
            
            if(result != null){ // 프사가 있으면

                String value = (String) result.get("IMG_PATH");
                
                // assets/ 뒷부분만 추출해서 화면에 넘겨줘야함
                String extractedPath = value.substring(value.indexOf("assets/") + "assets/".length());
                result.put("IMG_PATH", extractedPath);

                return result;
                
            }else{ // 프사가 없으면 기본프사로 설정
                return defaultImage;
            }

        }

}
