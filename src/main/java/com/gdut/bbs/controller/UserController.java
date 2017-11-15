package com.gdut.bbs.controller;

import com.gdut.bbs.domain.User;
import com.gdut.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public String add(User user){
        System.out.println(user);
        return "index";
    }

    @RequestMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(User user){
        return userService.checkUsernameExist(user)?
                "{\"valid\":\"true\"}":"{\"valid\":\"false\"}";
    }



    @RequestMapping("/checkEmail")
    @ResponseBody
    public String checkEmail(User user){
        return userService.checkEmailExist(user)?
                "{\"valid\":\"true\"}":"{\"valid\":\"false\"}";
    }
}
