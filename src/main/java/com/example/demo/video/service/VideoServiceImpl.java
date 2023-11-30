package com.example.demo.video.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.video.dto.VideoDto;
import com.example.demo.video.mapper.VideoMapper;

@Service
@PropertySource("classpath:application.properties")
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    @Transactional
    public String uploadVideo(VideoDto videoDto, MultipartFile videoFile) {
        try {
            if (videoFile != null && !videoFile.isEmpty()) {
                String originalFilename = videoFile.getOriginalFilename();
                String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
                String videoId = videoDto.getVideo_id();

                videoDto.setFilename(videoId+extension); // 파일 이름을 videoId로 설정

                // 프로젝트 내부의 상대 경로 설정
                String projectPath = System.getProperty("user.dir");
                String relativePath = "vue_front/public";
                // String relativePath = "vue_backend/src/main/resources/static/uploads";
                String uploadDirPath = projectPath + "/" + relativePath;

                // 파일 저장 경로 설정
                File uploadDir = new File(uploadDirPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                File uploadedFile = new File(uploadDir, videoId);
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
    @Override
    public List<VideoDto> getAllVideos() {
        return videoMapper.getAllVideos();
    }
}
