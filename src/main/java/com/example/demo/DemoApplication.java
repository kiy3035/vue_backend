package com.example.demo;

// import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
// @CrossOrigin(origins = "http://localhost:9000")
// @MapperScan("com.example.demo.mapper") // Mapper 인터페이스가 위치한 패키지를 정확하게 지정
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
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