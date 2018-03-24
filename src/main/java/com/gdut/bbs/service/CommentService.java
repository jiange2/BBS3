package com.gdut.bbs.service;

import com.gdut.bbs.domain.Comment;
import com.gdut.bbs.domain.Reply;
import com.gdut.bbs.domain.User;

import java.util.List;

public interface CommentService {

    List<Comment> selectPostList(Integer rid, Integer page);

    int insertComment(Comment comment, User user);
}
