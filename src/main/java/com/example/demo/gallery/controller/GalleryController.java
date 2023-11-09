package com.example.demo.gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.gallery.dto.GalleryDto;
import com.example.demo.gallery.service.GalleryService;
@RestController
@RequestMapping("/api/gallery")
public class GalleryController {

    private final GalleryService galleryService;

    @Autowired
    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveGallery(@RequestBody GalleryDto galleryDto) {
        galleryService.saveGallery(galleryDto);
        return new ResponseEntity<>("Gallery saved successfully", HttpStatus.OK);
    }

    // 다른 컨트롤러 메서드들을 추가할 수 있음
}
