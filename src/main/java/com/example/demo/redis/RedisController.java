package com.example.demo.redis;

import java.util.Map;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisTemplate<String, String> redisTemplate;

    @PostMapping("/redisTest")
    public ResponseEntity<?> addRedisKey(@RequestBody Map<String, Object> data) {
        System.out.println("데이터맨:" + data);
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("testKey", "testValue");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/redisTest/{key}")
    public ResponseEntity<?> getRedisKey(@PathVariable String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String value = valueOperations.get(key);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }
}