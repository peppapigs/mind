package com.xg;

import com.xg.entity.User;
import com.xg.mapper.LoginMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MindApplicationTests {

    @Autowired
    LoginMapper loginMapper; //加上@Mapper后不暴红

    @Test
    public void findALl(){
        System.out.println(loginMapper.findAll());
    }

    @Test
    public void update(){
        loginMapper.update("zhangsan", "lisi");
    }

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("wangwu");
        user.setPassword("123456");
        user.setEmail("123@qq.com");

        loginMapper.insert(user);
    }
}
