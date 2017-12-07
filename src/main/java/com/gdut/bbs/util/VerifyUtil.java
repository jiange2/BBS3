package com.gdut.bbs.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VerifyUtil {

    public static String randomChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static Random random = new Random();

    public static String getVerificationString(int len){
        int charsLength = randomChars.length();
        char[] verChars = new char[len];
        for(int i=0; i<len; ++i){
            verChars[i] = randomChars.charAt(random.nextInt(charsLength));
        }
        return new String(verChars);
    }

    public static boolean checkVerCode(String verCode, HttpSession session){
        String sessionVerCode = (String) session.getAttribute("verCode");
        return verCode != null && sessionVerCode != null
                && verCode.toUpperCase().equals(sessionVerCode.toUpperCase());
    }

    public static BufferedImage getVerificationImage(String verString){
        int w = 105;
        int h = 42;
        BufferedImage img = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = img.getGraphics();

        //设置背景颜色
        graphics.setColor(getRandomColor(200,255));
        graphics.fillRect(0,0,w,h);

        //设置圈
        graphics.setColor(getRandomColor(150,200));
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(w - 1)-w/2;
            int y = random.nextInt(h - 1)-h/2;
            int r = random.nextInt(h*2);
            graphics.drawArc(x,y,r,r,0,360);
        }


        graphics.setColor(getRandomColor(100,150));
        Graphics2D graphics2D = (Graphics2D) graphics;
        int padding = 5;
        int cWidth = 20;
        for (int i = 0; i < 4; i++) {
            int x = (padding * (i+1)) + (cWidth * i);
            double deg = (random.nextDouble() * 120 - 60) / 360  * Math.PI * 2;
            graphics2D.rotate(deg,x+10,20);
            graphics.setFont(new Font("Arial",Font.PLAIN,30));

            graphics.drawString(verString.substring(i,i+1),x,35);
            graphics2D.rotate(-deg,x+10,20);
        }
        return img;
    }

    private static Color getRandomColor(int st,int en){
        int range = en-st;
        int r = random.nextInt(range) + st;
        int g = random.nextInt(range) + st;
        int b = random.nextInt(range) + st;
        return new Color(r,g,b);
    }
}
