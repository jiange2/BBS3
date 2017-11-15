package com.gdut.bbs.controller;


import com.gdut.bbs.util.VerifyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/verify")
public class VerifyController {

    @RequestMapping("/verCode")
    public void getVerificationCode(HttpSession session,HttpServletResponse response) throws IOException {
        String verCode = VerifyUtil.getVerificationString();
        BufferedImage img = VerifyUtil.getVerificationImage(verCode);
        session.setAttribute("verCode",verCode);
        OutputStream os = response.getOutputStream();
        ImageIO.write(img,"jpg",os);
        os.flush();
        os.close();
    }

    @RequestMapping("/checkVerCode")
    @ResponseBody
    public String checkVerCode(String verCode, HttpSession session){
        System.out.println(verCode+":"+session.getAttribute("verCode"));
        String sessionVerCode = (String) session.getAttribute("verCode");
        return verCode != null && sessionVerCode != null
                && verCode.toUpperCase().equals(sessionVerCode.toUpperCase())?
                "{\"valid\":\"true\"}":"{\"valid\":\"false\"}";
    }
}
