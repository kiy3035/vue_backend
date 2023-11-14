package com.example.demo.video.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.video.dto.VideoDto;
import com.example.demo.video.mapper.VideoMapper;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

@Service
@PropertySource("classpath:application.properties")
public class VideoServiceImpl implements VideoService {

    @Value("${file.upload.directory}")
    private String uploadDirectory;

    @Resource
    private VideoMapper videoMapper;

    @Override
    @Transactional
    public String uploadVideo(VideoDto videoDto, MultipartFile videoFile) {
        try {
            if (videoFile != null && !videoFile.isEmpty()) {
                String fileName = videoFile.getOriginalFilename();
                // 파일 저장 경로 설정
                File uploadDir = new File(uploadDirectory);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                File uploadedFile = new File(uploadDirectory, fileName);
                videoFile.transferTo(uploadedFile);

                // MyBatis를 사용하여 비디오 정보 저장
                videoDto.setPath(uploadedFile.getAbsolutePath());
                videoMapper.insertVideo(videoDto);

                return "success";
            } else {
                return "No file uploaded.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error during file upload or data save.";
        }
    }
}
