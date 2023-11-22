package com.example.demo.like.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.like.mapper.LikeMapper;

@Service
public class LikeServiceImpl implements LikeService {
    
    private final LikeMapper likeMapper;
    
    public LikeServiceImpl(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    public int updateLike(Map<String, Object> data) {
        try {
            if (!data.isEmpty()) {
                likeMapper.upLike(data);
                likeMapper.insertLike_YN(data);
                return likeMapper.getLikeCount(data);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Map<String, Object>> getLikedVideoList(Map<String, Object> data){
System.out.println("이까지온" + data);
System.out.println("이까지$$$$$$$$$$$$$$" + likeMapper.getDupLike(data));

        return likeMapper.getDupLike(data);
    }

}
