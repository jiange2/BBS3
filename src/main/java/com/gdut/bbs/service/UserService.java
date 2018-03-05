package com.gdut.bbs.service;

import com.gdut.bbs.domain.User;


public interface UserService {

    boolean registerUser(User user);

    boolean selectEmailExist(User user);

    boolean selectUsernameExist(User user);

    User selectUser(User user);
}
