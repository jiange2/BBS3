package com.gdut.bbs.controller;
import com.gdut.bbs.annotation.Token;
import com.gdut.bbs.domain.Reply;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.service.ReplyService;
import com.gdut.bbs.util.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/reply")
@Controller
public class ReplyController {

    private static int maxNumOfWords = 3000;

    @Autowired
    private ReplyService replyService;

    @RequestMapping("/add")
    @Token(remove = true)
    @ResponseBody
    public Map<String,Object> add(Reply reply, HttpSession session,Integer pid){
        Map<String,Object> map = new HashMap<>();
        User user = (User) session.getAttribute("user");
        if(user != null && StringUtil.getRichTextLength(reply.getContent()) <= maxNumOfWords){
            if(replyService.insertReply(reply,user,pid) > 0){
                map.put("status","success");
            }else {
                map.put("errors","回复失败请重试");
            }
        }else{
            map.put("errors",user == null? "用户未登录！" : "文本字数过多！");
        }

        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(Integer pid,Integer page){
        Map<String,Object> map = new HashMap<>();
        if(pid == null || page == null){
            return map;
        }
        List<Reply> replies = replyService.selectList(pid,page);
        map.put("pageInfo",new PageInfo<>(replies));
        return map;
    }
}
