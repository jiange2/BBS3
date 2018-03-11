package com.gdut.bbs.service.impl;

import com.gdut.bbs.domain.Post;
import com.gdut.bbs.domain.Reply;
import com.gdut.bbs.domain.ReplyExample;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.mapper.PostMapper;
import com.gdut.bbs.mapper.ReplyMapper;
import com.gdut.bbs.service.ReplyService;
import com.gdut.bbs.util.XssUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private PostMapper postMapper;

    @Override
    public int insertReply(Reply reply, User user, Integer pid) {
        if(pid == null){
            return 0;
        }
        //设置回复的参数
        reply.init();
        reply.setPid(pid);
        reply.setUid(user.getUserid());
        reply.setUnickname(user.getNickname());
        reply.setUavatar(user.getAvatar());
        reply.setContent(XssUtil.cleanTagAndIfame(reply.getContent()));
        //回复+1
        Post post = new Post();
        post.setPid(pid);
        post.setReplyCount(0);
        post.setLastReplyTime(reply.getReplyTime());
        postMapper.addCountByPrimaryKey(post);
        return replyMapper.insert(reply);
    }

    @Override
    public List<Reply> selectList(Integer pid, Integer page) {
        PageHelper.startPage(page,10);
        ReplyExample replyExample = new ReplyExample();
        ReplyExample.Criteria criteria = replyExample.createCriteria();
        criteria.andPidEqualTo(pid);
        replyExample.setOrderByClause("reply_time desc");
        List<Reply> replies = replyMapper.selectByExampleWithBLOBs(replyExample);
        return replies;
    }
}
