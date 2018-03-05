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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService{

    private static String DEFAULT_ORDER_CLAUSE = "last_reply_time";
    private static Set<String> ALL_POST_CLAUSE;

    static {
        ALL_POST_CLAUSE = new HashSet<>();
        ALL_POST_CLAUSE.add(DEFAULT_ORDER_CLAUSE);
        ALL_POST_CLAUSE.add("reply_count");
        ALL_POST_CLAUSE.add("star_count");
        ALL_POST_CLAUSE.add("post_time");
    }

    @Autowired
    public PostMapper postMapper;

    @Override
    public int insertPost(Post post, User user) {
        post.init();
        post.setContent(XssUtil.cleanTag(post.getContent()));
        post.setUid(user.getUserid());
        post.setUavatar(user.getAvatar());
        post.setUnickname(user.getNickname());
        post.setTitle(XssUtil.cleanAll(post.getTitle()));
        System.out.println(post.getTitle()+":"+post.getContent());
        return postMapper.insert(post);
    }

    @Override
    public List<Post> selectPostList(Integer page,String orderClause) {
        PostExample example = new PostExample();
        if(orderClause == null || !ALL_POST_CLAUSE.contains(orderClause)){
            orderClause = DEFAULT_ORDER_CLAUSE;
        }
        example.setOrderByClause(orderClause + " desc");
        PageHelper.startPage(page,30);
        return postMapper.selectByExample(example);
    }

    @Override
    public Post selectPostById(Integer id) {
        return postMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addWatchCount(Post post) {
        Post postTemp = new Post();
        postTemp.setPid(post.getPid());
        postTemp.setWatchCount(0);
        postMapper.addCountByPrimaryKey(postTemp);
    }
}
