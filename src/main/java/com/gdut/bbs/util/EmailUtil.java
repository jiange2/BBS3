package com.gdut.bbs.util;

import javax.mail.MessagingException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class EmailUtil {

    private static volatile EmailSender emailSender;
    private static ResourceBundle bundle;
    private static String emailRegisterCodePattern;

    private static ConcurrentHashMap<String,Long> emailLastSendTime = new ConcurrentHashMap<>();

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

    public static int REGISTER_CODE_INTERVAL = 90000;

    public static void sendRegisterCode(String recipient,String str) {
        EmailSender sender = getEmailSender();
        emailLastSendTime.put(recipient,System.currentTimeMillis());
        TimerUtil.addTask(() -> {
            try {
                sender.send(recipient, "论坛注册码",
                        emailRegisterCodePattern.replace("?", str));
            } catch (MessagingException e) {
                //TODO
                e.printStackTrace();
            }
        },0);
        TimerUtil.addTask(()-> emailLastSendTime.remove(recipient), REGISTER_CODE_INTERVAL);
    }

    public static Long getLastSendTime(String recipient){
        return recipient != null ? emailLastSendTime.get(recipient) : null;
    }
}
