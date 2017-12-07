package com.gdut.bbs.service;

import com.gdut.bbs.domain.Post;
import com.gdut.bbs.domain.User;

public interface PostService {
    int insertPost(Post post, User user);
}
