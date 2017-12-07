package com.gdut.bbs.util;

import org.junit.Test;

import javax.mail.MessagingException;

public class EmailTest {

    @Test
    public void test() throws MessagingException {
        EmailSender emailSender = EmailUtil.getEmailSender();
        System.out.println(emailSender.getAuthenticator().getUsername());
        EmailUtil.sendRegisterCode("873296806@qq.com","你好啊");
    }

    @Test
    public void test2() throws MessagingException {
        EmailUtil.sendRegisterCode("873296806@qq.com@qq.com","110");
    }
}
