package com.example.demo.video.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.video.Entity.Video;
import com.example.demo.video.dto.VideoDto;
import com.example.demo.video.mapper.VideoMapper;
import com.example.demo.video.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;
    // @Autowired
    // private VideoMapper videoMapper;
    @Value("${file.upload.directory}")
    private String uploadDirectory;

    @Override
    @Transactional
    public void uploadVideo(VideoDto videoDto, MultipartFile videoFile) {
        if (videoFile != null && !videoFile.isEmpty()) {
            try {
                String fileName = videoFile.getOriginalFilename();
                // 파일 저장 경로 설정
                File uploadDir = new File(uploadDirectory);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                File uploadedFile = new File(uploadDirectory, fileName);
                videoFile.transferTo(uploadedFile);

                // 엔티티로 변환 및 저장
                Video video = VideoMapper.INSTANCE.videoDtoToVideo(videoDto);
                video.setFilePath(uploadedFile.getAbsolutePath());
                videoRepository.save(video);
            } catch (IOException e) {
                // 파일 업로드 또는 저장 중 오류 발생 시 처리
                e.printStackTrace();
            }
        }
    }
}