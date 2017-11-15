package com.gdut.bbs.service;

import com.gdut.bbs.JUnit4ClassRunner;
import com.gdut.bbs.domain.User;
import com.gdut.bbs.mapper.ReplyMapper;
import com.gdut.bbs.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/application-context.xml")
public class txTest {

    @Autowired
    public ReplyMapper replyMapper;

    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:config/spring/application-context.xml");
        UserService userService = (UserService) applicationContext.getBean(UserService.class);
        //userService.insertUser(new User());
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        /*for (String beanName: beanNames) {
            System.out.println(beanName);
        }*/
        /*Method method = userService.getClass().getMethod("insertUser",User.class);
        System.out.println(method);
        method.invoke(userService,new User());*/
    }

    @Test
    public void test2(){
        System.out.println(replyMapper);
    }
}
