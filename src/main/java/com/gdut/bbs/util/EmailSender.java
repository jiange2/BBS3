package com.gdut.bbs.util;



import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Properties;

public class EmailSender {
    public class MailAuthenticator extends Authenticator {

        /**
         * 邮箱
         */
        private String username;
        /**
         * 密码
         */
        private String passoword;

        public MailAuthenticator(String username, String passoword) {
            this.username = username;
            this.passoword = passoword;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username,passoword);
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassoword() {
            return passoword;
        }

        public void setPassoword(String passoword) {
            this.passoword = passoword;
        }
    }

    /**
     * 发送邮件的参数
     */
    private Properties props = System.getProperties();

    /**
     * 邮箱登录验证
     */
    private MailAuthenticator authenticator;

    /**
     * 邮箱session
     */
    private Session session;

    public EmailSender(String username, String password, String SMTPHostName){
        init(username,password,SMTPHostName);
    }

    public EmailSender(String username, String password){
        String SMTPHostName = "smtp." + username.split("@")[1];
        init(username,password,SMTPHostName);
    }

    private void init(String username,String password,String SMTPHostName){
        MailSSLSocketFactory factory = null;
        try {
            factory = new MailSSLSocketFactory();
            factory.setTrustAllHosts(true);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", factory);
        // 初始化props
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", SMTPHostName);
        // 验证
        authenticator = new MailAuthenticator(username, password);
        // 创建session
        session = Session.getInstance(props, authenticator);
    }

    /**
     * 发送邮件
     *
     * @param recipient
     *                收件人邮箱地址
     * @param subject
     *                邮件主题
     * @param content
     *                邮件内容
     * @throws AddressException
     * @throws MessagingException
     */
    public void send(String recipient, String subject, Object content)
            throws AddressException, MessagingException {
        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        message.setFrom(new InternetAddress(authenticator.getUsername()));
        // 设置收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipient));
        // 设置主题
        message.setSubject(subject);
        // 设置邮件内容
        message.setContent(content.toString(), "text/html;charset=UTF-8");
        // 发送
        Transport.send(message);
    }

    /**
     * 群发邮件
     *
     * @param recipients
     *                收件人们
     * @param subject
     *                主题
     * @param content
     *                内容
     * @throws AddressException
     * @throws MessagingException
     */
    public void send(List<String> recipients, String subject, Object content)
            throws AddressException, MessagingException {
        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        message.setFrom(new InternetAddress(authenticator.getUsername()));
        // 设置收件人们
        final int num = recipients.size();
        InternetAddress[] addresses = new InternetAddress[num];
        for (int i = 0; i < num; i++) {
            addresses[i] = new InternetAddress(recipients.get(i));
        }
        message.setRecipients(MimeMessage.RecipientType.TO, addresses);
        // 设置主题
        message.setSubject(subject);
        // 设置邮件内容
        message.setContent(content.toString(), "text/html;charset=utf-8");
        // 发送
        Transport.send(message);
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public MailAuthenticator getAuthenticator() {
        return authenticator;
    }

    public void setAuthenticator(MailAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
