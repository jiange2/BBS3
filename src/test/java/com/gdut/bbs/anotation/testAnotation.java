package com.gdut.bbs.anotation;

import com.gdut.bbs.annotation.Token;
import com.gdut.bbs.controller.PageController;
import org.junit.Test;

import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class testAnotation {

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = PageController.class;
        Method method = clazz.getMethod("registerPage");
        method.invoke(new PageController());
        Annotation[] annotation = method.getAnnotations();
        System.out.println(Arrays.toString(annotation));
    }
}
