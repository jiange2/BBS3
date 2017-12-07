package com.gdut.bbs.service.impl;


import com.gdut.bbs.domain.Post;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.mapper.PostMapper;
import com.gdut.bbs.service.PostService;
import com.gdut.bbs.util.XssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    public PostMapper postMapper;

    @Override
    public int insertPost(Post post, User user) {
        post.setContent(XssUtil.cleanTag(post.getContent()));
        post.setUid(user.getUserid());
        Date now = new Date();
        post.setLastReplyTime(now);
        post.setStarCount(0);
        post.setReplyCount(0);
        post.setWatchCount(0);
        post.setUnickname(user.getNickname());
        post.setTitle(XssUtil.cleanAll(post.getTitle()));
        return postMapper.insert(post);
    }
}
