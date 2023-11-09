package com.example.demo;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;


// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;


// @RestController
// @CrossOrigin(origins = "http://localhost:9000") // 프론트엔드 포트
// public class MainController {

//     @Autowired
//     private threeService threeService;

//     @GetMapping("/api/getTitles")
//     public List<dtoClass> getTitles() {
//         List<dtoClass> titleList = threeService.getTitles();
//         System.out.println("getTitles:" + titleList);
//         return titleList;
//     }

//     @PostMapping("/api/getDatas")
//     public List<Map<String, Object>> getDatas(@RequestBody String title) {

//         // 큰따옴표 제거
//         title = title.replaceAll("\"", "");

//         List<Map<String, Object>> dataList = new ArrayList<>();
//         dataList = threeService.getDatas(title);

//         System.out.println("getDatas:" + dataList);

//         return dataList;
//     }

//     @PostMapping("/api/data")
//     public String receiveData(@RequestBody List<dtoClass> dataList) { // RequestBody : HTTP 요청의 본문(body) 데이터를 Java 객체로 변환하는 데 사용
//         System.out.println("데이타:" + dataList);
//         String result = threeService.inputData(dataList);
//         return result;
        
//     }
    
// }
