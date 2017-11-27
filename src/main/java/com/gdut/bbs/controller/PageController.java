package com.gdut.bbs.controller;

import com.gdut.bbs.annotation.Token;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }


    @RequestMapping("/register")
    @Token(save = true)
    public String registerPage(){
        return "register";
    }
}
