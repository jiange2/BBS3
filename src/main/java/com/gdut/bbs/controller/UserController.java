package com.gdut.bbs.controller;

import com.gdut.bbs.annotation.Token;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.service.UserService;
import com.gdut.bbs.util.EmailUtil;
import com.gdut.bbs.util.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    public Map<String, Object> register(User user
            , String registerCode, HttpSession session) throws UnsupportedEncodingException {
        BindingResult errors = new BeanPropertyBindingResult(user, "user");
        validator.validate(user, errors, User.Register.class);
        Map<String, Object> map = new HashMap<>();
        if(!errors.hasErrors()){
            String registerCodeSession = (String) session.getAttribute("registerCode");
            if(registerCodeSession != null &&
                    registerCodeSession.equals(registerCode)){
                String email = (String) session.getAttribute("email");
                user.setEmail(email);
                session.removeAttribute("registerCode");
                userService.registerUser(user);
                session.setAttribute("user", user);
                map.put("valid", true);
            }else{
                map.put("errors", new String[]{"registerCode"});
            }
        }else{
            map.put("valid", false);
            map.put("errors", getAllErrorFieldName(errors));
        }
        return map;
    }

    private String[] getAllErrorFieldName(Errors errors){
        int len = errors.getErrorCount();
        String[] result = new String[len];
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for(int i=0 ; i<fieldErrors.size(); ++i){
            result[i] = fieldErrors.get(i).getField();
        }
        return result;
    }

    @Token(remove = true)
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(User user, HttpSession session, String verCode) {
        BindingResult errors = new BeanPropertyBindingResult(user, "user");
        validator.validate(user, errors, User.Login.class);
        Map<String, Object> map = new HashMap<>();
        if (errors.hasErrors()) {
            map.put("status", "failure");
            map.put("errors", getAllErrorFieldName(errors));
        } else {
            if (VerifyUtil.checkVerCode(verCode, session)) {
                session.removeAttribute("verCode");
                User loginUser = userService.selectUser(user);
                if (loginUser != null) {
                    session.setAttribute("user", loginUser);
                    map.put("status", "success");
                } else {
                    map.put("status", "failure");
                    map.put("errors", "用户名或者密码错误");
                }
            } else {
                map.put("status", "failure");
                map.put("errors", "验证码错误");
            }
        }

        return map;
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
    public Map getEmailRegCode(User user, HttpSession session, String verCode) {
        Map<String, Object> result = new HashMap<>();
        Long lastSendTime = EmailUtil.getLastSendTime(user.getEmail());
        Long nowTime = System.currentTimeMillis();
        if ((lastSendTime == null || nowTime - lastSendTime > INTERVAL)) { //上次发送时间低于@INTERVAL
            BindingResult errors = new BeanPropertyBindingResult(user, "user");
            validator.validate(user, errors, User.GetRegisterCode.class);
            if (!errors.hasErrors() && //邮件格式检查
                    VerifyUtil.checkVerCode(verCode, session) && //检查验证码是否正确
                    userService.selectEmailExist(user)) { //邮件是否已存在数据库
                String registerCode = VerifyUtil.getVerificationString(8);
                EmailUtil.sendRegisterCode(user.getEmail(), registerCode);
                session.setAttribute("registerCode", registerCode);
                session.setAttribute("email", user.getEmail());
                session.removeAttribute("verCode");
                result.put("valid", true);
                result.put("interval", INTERVAL);
                result.put("lastSendTime", EmailUtil.getLastSendTime(user.getEmail()));
            } else {
                result.put("valid", false);
            }
        } else {
            result.put("valid", false);
            result.put("interval", INTERVAL);
            result.put("lastSendTime", lastSendTime);
        }
        return result;
    }
}
