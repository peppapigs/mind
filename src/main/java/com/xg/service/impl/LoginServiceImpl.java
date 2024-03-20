package com.xg.service.impl;

import com.xg.entity.User;
import com.xg.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xg.service.LoginService;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public List<User> findAll() {
        return loginMapper.findAll();
    }

    @Override
    public int addUser(User user) {
        return loginMapper.insert(user);
    }

    @Override
    public int updateUser(String oldUsername, String newUsername) {
        return loginMapper.update(oldUsername, newUsername);
    }

    @Override
    public int deleteUser(String username) {
        return loginMapper.delete(username);
    }
}
