package com.gdut.bbs.controller;

import com.gdut.bbs.annotation.Token;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return "index";
    }

    @RequestMapping("/index")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/register")
    @Token(save = true)
    public String registerPage(){
        return "register";
    }
}
