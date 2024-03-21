package com.xg;

import com.xg.entity.User;
import com.xg.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusUserMapperTest {

    @Autowired
    UserMapper userMapper;
    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
        System.out.println("userMapper.selectList(null)" + users);
    }
}
