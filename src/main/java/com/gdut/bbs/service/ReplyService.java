package com.gdut.bbs.service;

import com.gdut.bbs.domain.Reply;
import com.gdut.bbs.domain.User;

import java.util.List;

public interface ReplyService {
    int insertReply(Reply reply, User user, Integer pid);

    List<Reply> selectList(Integer pid, Integer page);
}
