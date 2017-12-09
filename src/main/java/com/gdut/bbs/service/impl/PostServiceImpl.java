package com.gdut.bbs.service.impl;


import com.gdut.bbs.domain.Post;
import com.gdut.bbs.domain.PostExample;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.mapper.PostMapper;
import com.gdut.bbs.service.PostService;
import com.gdut.bbs.util.XssUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        post.setPostTime(now);
        post.setUavatar(user.getAvatar());
        post.setUnickname(user.getNickname());
        post.setTitle(XssUtil.cleanAll(post.getTitle()));
        return postMapper.insert(post);
    }

    @Override
    public List<Post> selectPostList(Integer page) {

        PostExample example = new PostExample();
        example.setOrderByClause("last_reply_time desc");
        PageHelper.startPage(page,30);

        return postMapper.selectByExample(example);
    }
}
