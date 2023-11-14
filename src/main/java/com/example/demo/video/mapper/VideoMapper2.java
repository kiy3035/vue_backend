package com.example.demo.video.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.video.Entity.Video;
import com.example.demo.video.dto.VideoDto2;

@Mapper(componentModel = "spring") // 이 부분을 추가
public interface VideoMapper2 {
    VideoMapper2 INSTANCE = Mappers.getMapper(VideoMapper2.class);

    @Mapping(source = "videoFile", target = "filePath")
    Video videoDtoToVideo(VideoDto2 videoDto);
}