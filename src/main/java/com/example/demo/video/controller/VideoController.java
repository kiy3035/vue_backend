package com.example.demo.video.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.video.dto.VideoDto;
// import com.example.demo.video.service.DropboxService;
import com.example.demo.video.service.VideoService;

@RestController
// @CrossOrigin(origins = "http://localhost:8001")
// @RequestMapping("/api")
public class VideoController {
    
    @Autowired
    private VideoService videoService;

    // @Autowired
    // private DropboxService dropboxService;

    @PostMapping("/api/upload")
    public String uploadVideo(@RequestPart("videoFile") MultipartFile videoFile, VideoDto videoDto,
                                @RequestParam("videoTitle") String title, @RequestParam("videoContent") String content,
                                @RequestParam("userEmail") String userEmail) {
                                    
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(title);
        System.out.println(content);
        // 파일 이름을 video_id로 설정
        String originalFilename = videoFile.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String videoId = System.currentTimeMillis() + extension; // 랜덤 ID 생성

        // 업로드된 비디오 파일과 DTO를 서비스에 전달
        videoDto.setVideo_id(videoId);
        videoDto.setFilename(videoId); // 파일 이름을 videoId로 설정
        videoDto.setVideoFile(videoFile);
        videoDto.setTitle(title);
        videoDto.setContent(content);
        videoDto.setUser_email(userEmail);


        // 데이터베이스에 비디오 정보를 저장
        // String result = videoService.uploadVideo(videoDto, videoFile); // 데이터베이스에 비디오 정보를 저장하도록 수정
        
       
       // 구글드라이브(보류)
        // try {
        //     googleDriveService.uploadFile(videoDto);
        // } catch (IOException e) {
        //     System.out.println("오류맨@@@@@@@@@@@@@@@@");
        //     // e.printStackTrace();
        // }
        // String result = dropboxService.uploadFile(videoDto);
        String result = "ㅎㅇ";
        System.out.println("result:" + result);
        return result;
    }
    
    
    @GetMapping("/api/videos")
    @ResponseBody
    public List<VideoDto> loadVideos() {
        List<VideoDto> videos = videoService.getAllVideos();
        videos.forEach(video -> {
            video.setVideo_url(video.getPath());
        });
        return videos;
    }

}