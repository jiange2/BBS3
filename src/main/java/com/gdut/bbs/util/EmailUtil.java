package com.gdut.bbs.util;

import javax.mail.MessagingException;
import java.util.ResourceBundle;

public class EmailUtil {

    private static volatile EmailSender emailSender;
    private static ResourceBundle bundle;
    private static String emailRegisterCodePattern;

    public static EmailSender getEmailSender(){
        if(emailSender == null){
            synchronized (EmailSender.class){
                if(emailSender == null){
                    bundle = ResourceBundle.getBundle("properties/Email");
                    emailRegisterCodePattern = bundle.getString("email.register.code.pattern");
                    String username = bundle.getString("email.username");
                    String password = bundle.getString("email.password");
                    String SMTPHostName = bundle.getString("email.SMTPHostName");
                    emailSender = new EmailSender(username,password,SMTPHostName);
                }
            }
        }
        return emailSender;
    }

    public static void sendRegisterCode(String recipient,String str){
        EmailSender sender = getEmailSender();
        try {
            sender.send(recipient,"论坛注册码",
                    emailRegisterCodePattern.replace("?",str));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
