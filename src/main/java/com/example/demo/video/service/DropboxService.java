package com.example.demo.video.service;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.CommitInfo;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadBuilder;
import com.dropbox.core.v2.files.WriteMode;
import com.example.demo.video.dto.VideoDto;
import com.example.demo.video.mapper.VideoMapper;

@Service
public class DropboxService {

    @Resource
    private VideoMapper videoMapper;

    // Dropbox 토큰
    private static final String ACCESS_TOKEN = "sl.BqpRUP6TFfi5NKEGA6KP7c3jvNR7QZBr6LV8S2r4o-MQAw-bMWZ1IY0-K2EgAnjOHmGjAELk_6_WYuGWECCWvWx9L-aNoW4nlVkSMAsRbXKPZSsjMC8FqtbYcScWh37oA4KF5qZw1PWAR1U";

    public void uploadFile(VideoDto videoDto) {
        try (InputStream inputStream = videoDto.getVideoFile().getInputStream()) {
            // Dropbox 연동을 위한 설정
            DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();

            // DbxClientV2 초기화
            DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

            // 파일 업로드 경로 설정 (확장자 추출하여 사용)
            String originalFilename = videoDto.getVideoFile().getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));

            // 파일 업로드 경로 설정 (확장자를 포함하여 설정)
            String uploadPath = "/WEB2_VIDEOS/" + videoDto.getVideoFile().getOriginalFilename() + extension;

            // CommitInfo 설정
            CommitInfo commitInfo = CommitInfo.newBuilder(uploadPath)
                    .withMode(WriteMode.ADD)
                    .withAutorename(true)
                    .build();

            // 파일 업로드
            UploadBuilder builder = client.files().uploadBuilder(uploadPath)
                    .withMode(WriteMode.ADD)
                    .withAutorename(true)
                    .withClientModified(commitInfo.getClientModified())
                    .withMute(true);

            // MyBatis를 사용하여 비디오 정보 저장
            String dbUploadPath = uploadFileAndGetDownloadLink(builder, client, uploadPath, inputStream);
            videoDto.setPath(dbUploadPath);
            videoMapper.insertVideo(videoDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String uploadFileAndGetDownloadLink(UploadBuilder builder, DbxClientV2 client, String uploadPath, InputStream inputStream) {
        try {
            
            // 파일 업로드 완료
            FileMetadata metadata = builder.uploadAndFinish(inputStream);
            System.out.println("Dropbox 업로드 성공: " + metadata.getName() + ", 사이즈: " + metadata.getSize());

            // 파일에 대한 다운로드 URL 가져오기
            String downloadUrl = client.files().getTemporaryLink(uploadPath).getLink();
            System.out.println("Dropbox 다운로드 URL: " + downloadUrl);

            return downloadUrl;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
