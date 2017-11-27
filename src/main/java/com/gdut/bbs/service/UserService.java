package com.gdut.bbs.service;

import com.gdut.bbs.domain.User;


public interface UserService {

    void registerUser(User user);

    boolean checkEmailExist(User user);

    boolean checkUsernameExist(User user);
}
