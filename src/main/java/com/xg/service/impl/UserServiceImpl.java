package com.xg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xg.entity.User;
import com.xg.mapper.UserMapper;
import com.xg.service.UserService;

/**
 * operation of table user from db ==> serviceImpl
 * 针对user表的数据库操作 service实现
 * * ServiceImpl实现了IService，提供了IService中基础功能的实现
 * * 若ServiceImpl无法满足业务需求，则可以使用自定的UserService定义方法，并在实现类中实现
 */
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
