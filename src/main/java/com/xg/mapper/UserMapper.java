package com.xg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xg.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * operation of user table from db ==> UserMapper
 * 针对user表的数据库操作mapper
 * Entity: com.xg.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
