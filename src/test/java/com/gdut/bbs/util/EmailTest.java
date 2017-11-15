package com.gdut.bbs.util;

import org.junit.Test;

import javax.mail.MessagingException;

public class EmailTest {

    @Test
    public void test() throws MessagingException {
        EmailSender emailSender = EmailUtil.getEmailSender();
        System.out.println(emailSender.getAuthenticator().getUsername());
        emailSender.send("992975556@qq.com","论坛注册码","110");
    }

    @Test
    public void test2(){
        EmailUtil.sendRegisterCode("992975556@qq.com","110");
    }
}
