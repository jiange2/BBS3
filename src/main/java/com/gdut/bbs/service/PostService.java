package com.gdut.bbs.service;

import com.gdut.bbs.domain.Post;
import com.gdut.bbs.domain.User;

import java.util.List;

public interface PostService {
    int insertPost(Post post, User user);

    List<Post> selectPostList(Integer page);
}
