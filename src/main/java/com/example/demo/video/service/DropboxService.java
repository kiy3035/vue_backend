// package com.example.demo.video.service;

// import com.dropbox.core.DbxRequestConfig;
// import com.dropbox.core.v2.DbxClientV2;
// import com.dropbox.core.v2.files.CommitInfo;
// import com.dropbox.core.v2.files.FileMetadata;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;
// import org.springframework.web.multipart.MultipartFile;

// import java.io.IOException;
// import java.io.InputStream;

// @Service
// public class DropboxService {

//     @Value("${dropbox.accessToken}") // application.properties 또는 application.yml에서 accessToken을 읽어옵니다.
//     private String accessToken;

//     public String uploadFileToDropbox(MultipartFile file, String filePath) {
//         try (InputStream inputStream = file.getInputStream()) {
//             // Dropbox API에 필요한 인증 정보 설정
//             DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
//             DbxClientV2 client = new DbxClientV2(config, accessToken);

//             // Dropbox에 파일 업로드
//             CommitInfo commitInfo = CommitInfo.newBuilder(filePath)
//                     .withAutorename(true)
//                     .build();
//             FileMetadata metadata = client.files().uploadBuilder(filePath)
//                     .withMode(com.dropbox.core.v2.files.WriteMode.ADD)
//                     .withClientModified(file.getOriginalFilename()) // 파일 이름을 지정 (옵션)
//                     .uploadAndFinish(inputStream, commitInfo);

//             // 업로드 성공 시 Dropbox에서의 파일 경로를 반환
//             return metadata.getPathLower();

//         } catch (IOException e) {
//             e.printStackTrace();
//             return null;
//         } catch (com.dropbox.core.DbxException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
// }
