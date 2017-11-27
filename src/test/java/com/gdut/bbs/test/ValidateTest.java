package com.gdut.bbs.test;

import com.gdut.bbs.JUnit4ClassRunner;
import com.gdut.bbs.controller.valid.UserValidRegisterGroup;
import com.gdut.bbs.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.validation.*;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.MessageInterpolator;
import java.io.UnsupportedEncodingException;
import java.util.*;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/application-context-webmvc.xml")
public class ValidateTest {

    @Autowired
    private LocalValidatorFactoryBean validator;

    @Test
    public void test1() throws UnsupportedEncodingException {
        /*ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:config/spring/application-context-webmvc.xml");
        System.out.println(context.getBean("validator").getClass());;*/
        MessageInterpolator interpolator =validator.getMessageInterpolator();
        User user = new User();
        user.setUsername("123");
        BindingResult errors = new BeanPropertyBindingResult(user,"user");
        validator.validate(user,errors, UserValidRegisterGroup.class);
        List<FieldError> errorList = errors.getFieldErrors();
        for(FieldError error:errorList){
            System.out.println(error.getField() +":"+ error.getDefaultMessage());
        }
        /*for(ConstraintViolation<User> violation:set){
            //System.out.println(violation);
            System.out.println(violation.getMessageTemplate());
            String str = violation.getMessage();
            System.out.println(new String(str));
            System.out.println(violation.getConstraintDescriptor());
            System.out.println(violation.getInvalidValue());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getRootBean());
            System.out.println(violation.getRootBeanClass());
            System.out.println("#####################");
        }*/
    }

    @Test
    public void test2() throws UnsupportedEncodingException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:config/spring/application-context-webmvc.xml");
       // System.out.println(context.getBean("messageSource").getClass());
        ReloadableResourceBundleMessageSource bundleMessageSource = (ReloadableResourceBundleMessageSource) context.getBean("messageSource");


        /*Object[] params = {"john",new Date().getTime()};
        String str = bundleMessageSource.getMessage("user.username.notNull",params,Locale.CHINESE);
        System.out.println(new String(str.getBytes("ISO-8859-1"),"UTF-8"));*/
        ResourceBundle resourceBundle = ResourceBundle.getBundle("properties/validation-message");
        Enumeration<String> enumeration = resourceBundle.getKeys();
        while (enumeration.hasMoreElements()){
            String str = enumeration.nextElement();
            System.out.println(str);
        }
    }
}
