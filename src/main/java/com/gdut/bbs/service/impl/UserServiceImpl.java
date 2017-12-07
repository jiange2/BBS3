package com.gdut.bbs.service.impl;

import com.gdut.bbs.domain.User;
import com.gdut.bbs.domain.UserExample;
import com.gdut.bbs.mapper.UserMapper;
import com.gdut.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void registerUser(User user) {
        user.setAvatar("/img/ava.png");
        user.setFollow(0);
        user.setNickname(user.getUsername());
        user.setPoint(0);
        user.setRegDate(new Date());
        userMapper.insert(user);
    }

    @Override
    public boolean selectEmailExist(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(user.getEmail());
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() <= 0;
    }

    @Override
    public boolean selectUsernameExist(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() <= 0;
    }

    @Override
    public User selectUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        System.out.println(user.getUsername()+":"+user.getPassword());

        List<User> users =  userMapper.selectByExample(userExample);
        if(users.size() > 0){
            return users.get(0);
        }else{
            return null;
        }
    }

}
