package com.xg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xg.mapper")//包如果没写对,就会在调用注入mapper对象时候报错没有可供使用的*mapper bean
public class MindApplication {
    public static void main(String[] args) {
        SpringApplication.run(MindApplication.class, args);
    }
}
