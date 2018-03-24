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
    public boolean registerUser(User user) {
        user.setAvatar("/static/avatar-default.png");
        user.setFollow(0);
        user.setNickname(user.getUsername());
        user.setPoint(0);
        user.setRegDate(new Date());
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean selectEmailExist(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(user.getEmail());
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() > 0;
    }

    @Override
    public boolean selectUsernameExist(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() > 0;
    }

    @Override
    public boolean selectNickNameExist(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getNickname());
        List<User> users = userMapper.selectByExample(userExample);
        return users.size() > 0;
    }

    @Override
    public int updateUser(User user) {
        System.out.println(user);
        int r =  userMapper.updateByPrimaryKeySelective(user);
        if(user.getNickname() != null || user.getAvatar() != null){
            userMapper.updateAllPostByPrimaryKey(user);
            userMapper.updateAllReplyByPrimaryKey(user);
        }
        return r;
    }

    @Override
    public User selectUser(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());

        List<User> users =  userMapper.selectByExample(userExample);
        if(users.size() > 0){
            return users.get(0);
        }else{
            return null;
        }
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
