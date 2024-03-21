package com.xg;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        //select("表字段1",.....) :选择查询的字段
        List<User> usersSelectLq = userMapper.selectList(new QueryWrapper<User>().select("uid").gt("uid", 3));
        usersSelectLq.forEach(System.out::println);

        List<User> usersLq = userMapper.selectList(new QueryWrapper<User>().gt("uid", 3));
        usersLq.forEach(System.out::println);

        /**
         * 分页查询paging
         */
        Page<User> userPage = new Page<>(1, 2);
        Page<User> page1_2 = userMapper.selectPage(userPage, new QueryWrapper<User>().between("uid", 3, 5));
        System.out.println("----------------page---------------------");
        System.out.println("current: " + page1_2.getCurrent());
        System.out.println("size: " + page1_2.getSize());
        System.out.println("total: " + page1_2.getTotal());
        System.out.println("Records:" + page1_2.getRecords());
        System.out.println("----------------------------------------");

        System.out.println("----------------lambda-------------------");
        List<User> usersBtw = userMapper.selectList(
                new QueryWrapper<User>().select("uid", "username")
                        .lambda().between(User::getUid, 2, 5));
        usersBtw.forEach(System.out::println);
        System.out.println("----------------------------------------");
    }
}
