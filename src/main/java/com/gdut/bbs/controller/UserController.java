package com.gdut.bbs.controller;

import com.gdut.bbs.annotation.Token;
import com.gdut.bbs.domain.JsonResult;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.service.UserService;
import com.gdut.bbs.util.EmailUtil;
import com.gdut.bbs.util.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    LocalValidatorFactoryBean validator;

    @RequestMapping("/currentUser")
    @ResponseBody
    public JsonResult getCurrentUser(HttpSession session) {
        JsonResult result = new JsonResult();
        User user = (User) session.getAttribute("user");
        result.addInfo("user", user);
        result.setStatus(user != null);
        return result;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public JsonResult logout(HttpSession session) {
        session.removeAttribute("user");
        return new JsonResult(true);
    }

    @RequestMapping("/register")
    @ResponseBody
    public JsonResult register(@Validated(value = {User.Login.class}) User user,
            BindingResult errors, String registerCode, HttpSession session) {
        JsonResult result = new JsonResult();
        if (checkForm(errors,result) &&
                !checkUsernameExist(user,result) &&
                checkReigsterCode(registerCode,session, result)) {
            String email = (String) session.getAttribute("email");
            user.setEmail(email);
            if(userService.registerUser(user)){
                User loginUser = userService.selectUser(user);
                session.setAttribute("user", loginUser);
                result.addInfo("user",user);
            }
        }
        result.setStatus();
        return result;
    }

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(@Validated(value = {User.Login.class}) User user,
                            BindingResult errors, HttpSession session, String captcha) {
        JsonResult result = new JsonResult();
        if (checkForm(errors, result) && checkCaptcha(captcha, session, result)) {
            User loginUser = userService.selectUser(user);
            if (loginUser != null) {
                session.setAttribute("user", loginUser);
                result.addInfo("user", loginUser);
            } else {
                result.addError("password", "用户名或密码错误");
            }
        }

        result.setStatus();
        return result;
    }


    @RequestMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(User user, HttpSession session) {
        return userService.selectUsernameExist(user) ?
                "{\"valid\":\"true\"}" : "{\"valid\":\"false\"}";
    }


    @RequestMapping("/checkEmail")
    @ResponseBody
    public String checkEmail(User user) {
        return userService.selectEmailExist(user) ?
                "{\"valid\":\"true\"}" : "{\"valid\":\"false\"}";
    }

    private static int INTERVAL = EmailUtil.REGISTER_CODE_INTERVAL;

    @RequestMapping("/getEmailRegCode")
    @ResponseBody
    public JsonResult getEmailRegCode(@Validated(value = {User.GetRegisterCode.class}) User user,
                                      BindingResult errors, HttpSession session, String captcha) {
        JsonResult result = new JsonResult();
        Long lastSendTime = EmailUtil.getLastSendTime(user.getEmail());
        Long nowTime = System.currentTimeMillis();
        if ((lastSendTime == null || nowTime - lastSendTime > INTERVAL) && //上次发送时间低于@INTERVAL
                checkForm(errors, result) && //邮件格式检查
                checkCaptcha(captcha, session, result) && //检查验证码是否正确
                !checkEmailExist(user, result)) { //邮件是否已存在数据库
            String registerCode = VerifyUtil.getVerificationString(8);
            EmailUtil.sendRegisterCode(user.getEmail(), registerCode);
            lastSendTime = System.currentTimeMillis();
            session.setAttribute("registerCode", registerCode);
            session.setAttribute("email", user.getEmail());
            session.removeAttribute("captcha");
        }
        result.addInfo("lastSendTime", lastSendTime);
        result.setStatus();
        return result;
    }

    private boolean checkForm(BindingResult errors, JsonResult jsonResult) {
        if (errors.hasErrors()) {
            jsonResult.addErrors(errors);
            return false;
        }

        return true;
    }

    private boolean checkCaptcha(String captcha, HttpSession session, JsonResult jsonResult) {
        String sessionCaptcha = (String) session.getAttribute("captcha");
        if (captcha != null && sessionCaptcha != null
                && captcha.toUpperCase().equals(sessionCaptcha.toUpperCase())) {
            session.removeAttribute("captcha");
            jsonResult.addInfo("resetCaptcha", true);
            return true;
        } else {
            jsonResult.addError("captcha", "验证码错误");
            return false;
        }
    }

    private boolean checkReigsterCode(String registerCode, HttpSession session, JsonResult jsonResult) {
        String sessionCode = (String) session.getAttribute("registerCode");
        if (registerCode != null && sessionCode != null
                && registerCode.toUpperCase().equals(sessionCode.toUpperCase())) {
            session.removeAttribute("registerCode");
            jsonResult.addInfo("resetCaptcha", true);
            return true;
        } else {
            jsonResult.addError("registerCode", "注册码错误");
            return false;
        }
    }

    private boolean checkEmailExist(User user,JsonResult result){
        boolean exist = userService.selectEmailExist(user);
        if(exist){
            result.addError("email","邮箱已被使用");
        }
        return exist;
    }

    private boolean checkUsernameExist(User user,JsonResult result){
        boolean exist = userService.selectUsernameExist(user);
        if(exist){
            result.addError("username","用户名已存在");
        }
        return exist;
    }
}
