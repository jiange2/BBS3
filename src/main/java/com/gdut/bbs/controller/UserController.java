package com.gdut.bbs.controller;

import com.gdut.bbs.annotation.Token;
import com.gdut.bbs.controller.valid.UserValidRegisterGroup;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.service.UserService;
import com.gdut.bbs.util.EmailUtil;
import com.gdut.bbs.util.LogUtil;
import com.gdut.bbs.util.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    LocalValidatorFactoryBean validator;

    @Token(remove = true)
    @RequestMapping("/register")
    @ResponseBody
    public Map<String,Object> register(User user ,String rePassword
            , String registerCode,HttpSession session) throws UnsupportedEncodingException {
        BindingResult errors = new BeanPropertyBindingResult(user,"user");
        validator.validate(user,errors, UserValidRegisterGroup.class);
        Map<String,Object> map = new HashMap<>();
        if(errors.hasErrors()){
            map.put("status","failure");
            map.put("errors",VerifyUtil.SimplifyBindingResult(errors));
        }else{
            String email = (String) session.getAttribute("email");
            String username = (String)session.getAttribute("username");
            if(!user.getPassword().equals(rePassword)  ||
                    !user.getUsername().equals(username)){
                map.put("status","failure");
                map.put("errors","瞎操作的吧");
            }else{
                String registerCodeSession = (String) session.getAttribute("registerCode");
                if(!user.getEmail().equals(email) ||
                        registerCodeSession == null ||
                        !registerCodeSession.equals(registerCode) ){
                    map.put("status","failure");
                    map.put("errors","注册码输入错误,请仔细输入");
                }else{
                    session.removeAttribute("registerCode");
                    userService.registerUser(user);
                    session.setAttribute("user",user);
                    map.put("status","success");
                }
            }
        }
        return map;
    }

    @RequestMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(User user,HttpSession session){
        boolean flag = userService.checkUsernameExist(user);
        session.setAttribute("username",user.getUsername());
        return flag ? "{\"valid\":\"true\"}":"{\"valid\":\"false\"}";
    }



    @RequestMapping("/checkEmail")
    @ResponseBody
    public String checkEmail(User user){
        return userService.checkEmailExist(user)?
                "{\"valid\":\"true\"}":"{\"valid\":\"false\"}";
    }

    public static int INTERVAL = 90000;

    @RequestMapping("/getEmailRegCode")
    @ResponseBody
    public Map getEmailRegCode(User user, HttpSession session,String verCode){
        LogUtil.newLog();
        LogUtil.endLog();
        LogUtil.newLog();
        Map<String,String> map = new HashMap<>();
        Long lastSendTime = (Long) session.getAttribute("lastSendTime");
        Long nowTime = System.currentTimeMillis();
        if((lastSendTime == null || nowTime-lastSendTime > INTERVAL)){
            LogUtil.log("checkEmailExist");
            if(userService.checkEmailExist(user)){
                LogUtil.log("checkVerCode");
                if(VerifyUtil.checkVerCode(verCode,session) ){
                    String registerCode = VerifyUtil.getVerificationString(8);
                    try {
                        LogUtil.log("sendRegisterCode");
                        EmailUtil.sendRegisterCode(user.getEmail(),registerCode);
                        LogUtil.log("setAttribute");
                        session.setAttribute("registerCode",registerCode);
                        session.setAttribute("email",user.getEmail());
                        session.setAttribute("lastSendTime",nowTime);
                        map.put("leftTime",nowTime+"");
                    } catch (MessagingException e){
                        map.put("message","注册码发送失败");
                        map.put("leftTime",0+"");
                    }
                }else{
                    map.put("message","验证码错误");
                    map.put("leftTime",0+"");
                }
            }else{
                map.put("message","邮箱已被使用");
                map.put("leftTime",0+"");
            }
        }else{
            map.put("leftTime",lastSendTime+"");
        }
        map.put("interval",INTERVAL+"");
        LogUtil.endLog();
        return map;
    }
}
