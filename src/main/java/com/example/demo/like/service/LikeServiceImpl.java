// package com.example.demo.like.service;

// import java.util.List;
// import java.util.Map;
// import java.util.ArrayList;

// import org.springframework.stereotype.Service;

// import com.example.demo.like.dto.LikeDto;
// import com.example.demo.like.mapper.LikeMapper;

// @Service
// public class LikeServiceImpl implements LikeService {
    
//     private final LikeMapper likeMapper;
    
//     public LikeServiceImpl(LikeMapper likeMapper) {
//         this.likeMapper = likeMapper;
//     }

//     public void updateUserInfo(Map<String, Object> userInfo) {
//         try {
//             if (!userInfo.isEmpty()) {
//                 likeMapper.updateUserInfo(userInfo);
//             }
//         } 
//         catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
    

//     // public String login(Map<String, Object> userInfo) {
        
//     //     if (!userInfo.isEmpty()) {
//     //         Map<String, Object> result = likeMapper.matchUserInfo(userInfo);
//     //         System.out.println("결과값: " + result);

//     //         if(result == null){
//     //             return null;
//     //         }
//     //         return (String) result.get("EMAIL");
//     //     }
//     //     return null;
//     // }


// }
