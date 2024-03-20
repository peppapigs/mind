package com.xg.mapper;

import com.xg.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    /**
     * find all user
     */
    List<User> findAll();

    /**
     * insert user
     */
    int insert(User user);

    /**
     * delete user(by name)
     */
    int delete(String username);

    /**
     * update user (later excluding password)
     */
    int update(String oldUsername, String newUsername);
}
