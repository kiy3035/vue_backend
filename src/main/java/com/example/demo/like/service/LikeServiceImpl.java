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
                if(likeMapper.getDupLike2(data).size() > 0){
                    if(likeMapper.getDupLike2(data).get(0).get("VIDEO_ID").equals(data.get("videoId"))){
                        likeMapper.likeMinus1(data);
                        likeMapper.deleteLike(data);
                        return likeMapper.getLikeCount(data);
                    }
                }
                else{
                    likeMapper.likePlus1(data);
                    likeMapper.insertLike(data);
                    return likeMapper.getLikeCount(data);
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Map<String, Object>> getLikedVideoList(Map<String, Object> data){
        return likeMapper.getDupLike(data);
    }

}
