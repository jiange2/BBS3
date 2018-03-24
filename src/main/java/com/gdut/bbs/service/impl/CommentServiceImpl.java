package com.gdut.bbs.service.impl;


import com.gdut.bbs.domain.*;
import com.gdut.bbs.mapper.CommentMapper;
import com.gdut.bbs.mapper.ReplyMapper;
import com.gdut.bbs.service.CommentService;
import com.gdut.bbs.service.ReplyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentMapper mapper;

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public List<Comment> selectPostList(Integer rid, Integer page) {
        CommentExample example = new CommentExample();
        CommentExample.Criteria  criteria = example.createCriteria();
        criteria.andRidEqualTo(rid);
        PageHelper.startPage(page,5);
        return mapper.selectByExample(example);
    }

    @Override
    public int insertComment(Comment comment, User user) {
        comment.setUid(user.getUserid());
        comment.setUnickname(user.getNickname());
        comment.setCommentTime(new Date());
        Reply reply = new Reply();
        reply.setRid(comment.getRid());
        reply.setCommentCount(0);
        replyMapper.addCountByPrimaryKey(reply);
        return mapper.insert(comment);
    }
}
