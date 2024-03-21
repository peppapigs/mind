package com.xg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xg.entity.User;
import com.xg.mapper.UserMapper;
import com.xg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * operation of table user from db ==> serviceImpl
 * 针对user表的数据库操作 service实现
 * * ServiceImpl实现了IService，提供了IService中基础功能的实现
 * * 若ServiceImpl无法满足业务需求，则可以使用自定的UserService定义方法，并在实现类中实现
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    public List<User> getAll(){
        return userMapper.selectList(
                new QueryWrapper<User>()
                        .select("uid", "username", "email"));
    }

    /**
     * 更新用户
     */
    public String updateNameByEmail(User user){
        int update = userMapper.update(
                user,
                new UpdateWrapper<User>()
                        .like("email", "gmail")
                        .set("username", "小伙子"));
        if(update > 0)
            return "updated!";
        else
            return "updated failed!";
    }
}
