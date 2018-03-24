package com.gdut.bbs.controller;

import com.gdut.bbs.domain.Comment;
import com.gdut.bbs.domain.JsonResult;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService service;

    @RequestMapping("/list")
    @ResponseBody
    public JsonResult getCommentId(Integer rid,Integer page){
        JsonResult result = new JsonResult();
        if(rid == null){
            return result;
        }
        result.addInfo("pageInfo",new PageInfo<>(service.selectPostList(rid,page)));
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult addComment(Comment comment, HttpSession session){
        JsonResult result = new JsonResult();
        User user = (User) session.getAttribute("user");
        if(user != null || comment.getContent() == null || comment.getContent().length() <= 0){
            if(service.insertComment(comment,user) > 0){
                result.addInfo("cid",comment.getCid());
            }else{
                result.addError("m","插入失败");
            }
        }else{
            result.addError("m","用户未登录");
        }
        return result;
    }
}
