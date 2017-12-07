package com.gdut.bbs.controller;


import com.gdut.bbs.domain.Post;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/post")
public class PostController {


    @Autowired
    PostService postService;


    @RequestMapping("/add")
    @ResponseBody
    public Map<String,Object> add(@Valid Post post, HttpSession session,BindingResult errors) throws InterruptedException {
        Thread.sleep(10000);
        Map<String,Object> map = new HashMap<>();
        User user = (User) session.getAttribute("user");
        System.out.println(post.getTitle());
        System.out.println(post.getContent());
        if(user != null || errors.hasErrors()){
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
}
