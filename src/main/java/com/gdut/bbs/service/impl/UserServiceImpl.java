package com.gdut.bbs.service.impl;

import com.gdut.bbs.domain.User;
import com.gdut.bbs.domain.UserExample;
import com.gdut.bbs.mapper.UserMapper;
import com.gdut.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void registerUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public boolean checkEmailExist(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(user.getEmail());
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() <= 0;
    }

    @Override
    public boolean checkUsernameExist(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() <= 0;
    }

}
