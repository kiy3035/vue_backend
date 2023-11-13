package com.example.demo.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.video.Entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}
