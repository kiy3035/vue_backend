package com.example.demo.login.service;

// import java.util.List;
// import java.util.Map;

// import org.springframework.stereotype.Service;

// import com.example.demo.dto.dtoClass;
// import com.example.demo.mapper.threeMapper;

// @Service
// public class threeServiceImpl implements threeService {
    
//     private final threeMapper threeMapper;
    
//     public threeServiceImpl(threeMapper threeMapper) {
//         this.threeMapper = threeMapper;
//     }

//     public String inputData(List<dtoClass> dataList) {
//         try {
//             System.out.println("1111111111111111");
//             if (!dataList.isEmpty()) {

//                 dtoClass firstData = dataList.get(0); // 첫 번째 데이터만 대상

//                 if ("insert".equals(firstData.getSave())) {
//                     threeMapper.insertMst(dataList.get(0)); // 첫 번째 데이터만 mst 호출
                    
//                     for (dtoClass data : dataList) {    // 모든 데이터에 대해 dtl 호출
//                         threeMapper.insertDtl(data);
//                     }
//                 }
//                 else if ("update".equals(firstData.getSave())) {
//                     threeMapper.updateMst(dataList.get(0)); // 첫 번째 데이터만 mst 호출
//                     threeMapper.updateDtl1(dataList.get(0)); // 삭제
                    
//                     for (dtoClass data : dataList) {    // 새로 생성
//                         threeMapper.updateDtl2(data);
//                     }
//                 }
//                 else if ("delete".equals(firstData.getSave())) {
//                     for (dtoClass data : dataList) {    
//                         threeMapper.deleteDtl(data);
//                     }
//                     threeMapper.deleteMst(dataList.get(0)); 
//                 }

//             }
            
//             System.out.println("2222222222222222");

//             return null;
//         } 
//         catch (Exception e) {
//             e.printStackTrace();
//             // 오류 처리
//             return "오류 발생";
//         }
//     }
    

//     public List<dtoClass> getTitles() {
//         return threeMapper.selectTitles();
//     }    

    
//     public List<Map<String, Object>> getDatas(String title) {
//         return threeMapper.selectDatas(title);
//     }    

// }
