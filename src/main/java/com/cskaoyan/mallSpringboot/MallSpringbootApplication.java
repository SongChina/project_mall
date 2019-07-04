package com.cskaoyan.mallSpringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cskaoyan.mallSpringboot.mapper")
public class MallSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSpringbootApplication.class, args);
    }

}
