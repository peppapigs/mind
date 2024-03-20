package com.xg;

import com.xg.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnotherTest {

    @Autowired
    LoginService loginService; //impl添加@service依旧

    @Test
    public void updateUser(){
        int ret = loginService.updateUser("lisi", "zhangsan");
        System.out.println("返回值: " + ret);
    }
}
