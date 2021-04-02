package com.yunzhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yunzhi.mapper")
public class TeacherDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherDemoApplication.class, args);
    }

}
