package com.gdut.bbs.controller;


import com.gdut.bbs.annotation.Token;
import com.gdut.bbs.domain.Post;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.service.PostService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/post")
public class PostController {


    @Autowired
    PostService postService;


    @Token(remove = true)
    @RequestMapping("/add")
    @ResponseBody
    public Map<String,Object> add(@Valid Post post, BindingResult errors,HttpSession session) {
        Map<String,Object> map = new HashMap<>();
        User user = (User) session.getAttribute("user");
        if(user != null && !errors.hasErrors()){
            if(postService.insertPost(post,user) > 0){
                map.put("result","success");
            }else{
                map.put("result","failure");
            }
        }else{
            map.put("result","failure");
        }
        return map;
    }

    @RequestMapping("/list/{page}")
    @ResponseBody
    public Map<String,Object> list(@PathVariable Integer page, HttpServletRequest request){
        if (page == null){
            page = 1;
        }
        HashMap<String,Object> map = new HashMap<>();
        List<Post> list =  postService.selectPostList(page);
        PageInfo<Post> pageInfo = new PageInfo<>(list);
        map.put("posts",list);
        map.put("pageInfo",pageInfo);

        return map;
    }
}
