package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@CrossOrigin(origins = {"http://localhost:8001" , "https://web-frontvue-57lz2alptar5jk.sel4.cloudtype.app"})
@Import({DefaultDatabaseConfig.class, FescoDatabaseConfig.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
// 허용할 오리진(Origin) 설정
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 해당 패턴에 대해서 CORS 설정을 추가
                        .allowedOrigins("http://localhost:8001", "https://web-frontvue-57lz2alptar5jk.sel4.cloudtype.app") // 허용할 오리진(Origin) 설정
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드 설정
                        .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization") // 허용할 헤더 설정
                        .allowCredentials(true); // Credentials 허용 여부
            }
        };
    }
    
    @Bean
    public ErrorViewResolver customErrorViewResolver() {
        final ErrorViewResolver resolver = (request, status, model) -> {
            if (status == HttpStatus.NOT_FOUND) {
                return new ModelAndView("forward:/test.html");
            }
            return null;
        };
        return resolver;
    }
}