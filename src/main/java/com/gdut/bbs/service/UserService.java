package com.gdut.bbs.service;

import com.gdut.bbs.domain.User;


public interface UserService {

    boolean registerUser(User user);

    //TODO 存在查找方法合并
    boolean selectEmailExist(User user);

    boolean selectUsernameExist(User user);

    boolean selectNickNameExist(User user);

    int updateUser(User user);

    User selectUser(User user);

    User selectUserById(Integer id);
}
