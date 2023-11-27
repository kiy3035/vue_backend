package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:8001")
@MapperScan(basePackages = { "com.example.demo.video.mapper"
                           , "com.example.demo.login.mapper"
                           , "com.example.demo.mypage.mapper"
                           , "com.example.demo.like.mapper" 
                           , "com.example.demo.comment.mapper" 
                           , "com.example.demo.community.mapper"
                           , "com.example.demo.realgrid.mapper"
                        }) // Mapper 인터페이스가 위치한 패키지를 정확하게 지정
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 해당 패턴에 대해서 CORS 설정을 추가
                        .allowedOrigins("http://localhost:8001") // 허용할 오리진(Origin) 설정
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드 설정
                        .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization") // 허용할 헤더 설정
                        .allowCredentials(true); // Credentials 허용 여부
            }
        };
    }
    
    // @Bean
    // public ErrorViewResolver customErrorViewResolver() {
    //     final ErrorViewResolver resolver = (request, status, model) -> {
    //         if (status == HttpStatus.NOT_FOUND) {
    //             return new ModelAndView("forward:/test.html");
    //         }
    //         return null;
    //     };
    //     return resolver;
    // }
}