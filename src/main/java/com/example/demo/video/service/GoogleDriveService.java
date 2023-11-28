// package com.example.demo.video.service;

// import java.io.IOException;
// import java.net.URI;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;

// import org.springframework.stereotype.Service;

// import com.example.demo.video.dto.VideoDto;

// import antlr.ByteBuffer;

// @Service
// public class GoogleDriveService {
    
//     private static final String APPLICATION_NAME = "videos";
//     private static final String CREDENTIALS_FILE_PATH = "C:\\videos-406501-d738ea49b78e.json"; // 인증 정보 JSON 파일 경로
//     private static final String UPLOAD_URL = "https://www.googleapis.com/upload/drive/v3/files?uploadType=multipart";
//     private static final String API_KEY = "AIzaSyD5ybo6yENlrVF9NkG8xzp4npOgJu-SHms";
//     private static final String FOLDER_ID = "19dvMm20G-IifYoOavKZOKYIfPfVfQqfn";

//      public String uploadFile(VideoDto videoDto) throws IOException, InterruptedException {

//         HttpClient httpClient = HttpClient.newHttpClient();

//         HttpRequest request = HttpRequest.newBuilder()
//                 .uri(URI.create(UPLOAD_URL + "&key=" + API_KEY))
//                 .header("Content-Type", "multipart/related; boundary=foo_bar_baz")
//                 .POST(buildMultipartBody(videoDto))
//                 .build();

//         HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

//         System.out.println("Response Code: " + response.statusCode());
//         System.out.println("Response Body: " + response.body());

//         return "Upload successful";
//     }

//     private HttpRequest.BodyPublisher buildMultipartBody(VideoDto videoDto) throws IOException {
//         Path videoPath = Paths.get(videoDto.getVideoFile().toURI());
//         String boundary = "foo_bar_baz";

//         return HttpRequest.BodyPublishers.ofMultipartData(
//                 new MultipartDataPublisher(boundary, "file", videoDto.getVideo_id(), Files.readAllBytes(videoPath)),
//                 HttpRequest.BodyPublishers.ofString("name=" + videoDto.getVideo_id()),
//                 HttpRequest.BodyPublishers.ofString("parents=" + FOLDER_ID)
//         );
//     }

//     public static class MultipartDataPublisher implements HttpRequest.BodyPublisher {

//         private final byte[] data;
//         private final String boundary;
//         private final String name;
//         private final String fileName;

//         public MultipartDataPublisher(String boundary, String name, String fileName, byte[] data) {
//             this.boundary = boundary;
//             this.name = name;
//             this.fileName = fileName;
//             this.data = data;
//         }

//         @Override
//         public long contentLength() {
//             return data.length;
//         }

//         @Override
//         public void subscribe(Flow.Subscriber<? super ByteBuffer> subscriber) {
//             try {
//                 subscriber.onSubscribe(new ByteArraySubscription(subscriber, data));
//             } catch (Exception e) {
//                 subscriber.onError(e);
//             }
//         }

//         private class ByteArraySubscription implements Flow.Subscription {

//             private final Flow.Subscriber<? super ByteBuffer> subscriber;
//             private final byte[] data;
//             private int remaining;

//             public ByteArraySubscription(Flow.Subscriber<? super ByteBuffer> subscriber, byte[] data) {
//                 this.subscriber = subscriber;
//                 this.data = data;
//                 this.remaining = data.length;
//             }

//             @Override
//             public void request(long n) {
//                 if (n > 0) {
//                     int length = Math.min((int) n, remaining);
//                     ByteBuffer buffer = ByteBuffer.wrap(data, data.length - remaining, length);
//                     subscriber.onNext(buffer);
//                     remaining -= length;
//                     if (remaining == 0) {
//                         subscriber.onComplete();
//                     }
//                 } else {
//                     subscriber.onError(new IllegalArgumentException("Invalid request: " + n));
//                 }
//             }

//             @Override
//             public void cancel() {
//                 remaining = 0;
//             }
//         }
//     }
// }
