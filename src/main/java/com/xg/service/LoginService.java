package com.xg.service;

import com.xg.entity.User;

import java.util.List;

public interface LoginService {

    public List<User> findAll();

    public int addUser(User user);

    public int updateUser(String oldUsername, String newUsername);

    public int deleteUser(String username);
}
