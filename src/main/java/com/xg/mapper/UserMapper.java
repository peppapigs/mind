package com.xg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xg.entity.User;

/**
 * operation of user table from db ==> UserMapper
 * 针对user表的数据库操作mapper
 * BaseMapper是MyBatis-Plus提供的模板mapper，其中包含了基本的CRUD方法，泛型为操作的实体类型
 * Entity: com.xg.User
 */
//@Mapper
public interface UserMapper extends BaseMapper<User> {
}
