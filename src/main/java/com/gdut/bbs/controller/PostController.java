package com.gdut.bbs.controller;

import com.gdut.bbs.annotation.Token;
import com.gdut.bbs.domain.JsonResult;
import com.gdut.bbs.domain.Post;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.service.PostService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult add(@Valid Post post, BindingResult errors, HttpSession session) {
        JsonResult result = new JsonResult();
        User user = (User) session.getAttribute("user");
        if(user != null && !errors.hasErrors()){
            if(!(postService.insertPost(post,user) > 0)){
                result.addError("content","帖子发表失败");
            }
        }else{
            result.addError("content",user == null?"用户未登录":"标题或帖子内容出错");
        }
        return result;
    }

    @RequestMapping("/list/{order}/{page}")
    @ResponseBody
    public Map<String,Object> list(@PathVariable String order,@PathVariable Integer page)  {
        if (page == null){
            page = 1;
        }
        HashMap<String,Object> map = new HashMap<>();
        List<Post> list =  postService.selectPostList(page,order);
        PageInfo<Post> pageInfo = new PageInfo<>(list);
        map.put("pageInfo",pageInfo);

        return map;
    }

    @RequestMapping("/getPost")
    @ResponseBody
    public Post getPost(Integer pid,HttpSession session){
        Set<Integer> readSet = (Set<Integer>) session.getAttribute("readSet");
        if(readSet == null){
            session.setAttribute("readSet",(readSet = new HashSet<>()));
        }
        Post post = postService.selectPostById(pid);
        if(!readSet.contains(pid)){
            postService.addWatchCount(post);
            readSet.add(pid);
        }
        return post;
    }
}
