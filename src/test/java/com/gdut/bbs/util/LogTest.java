package com.gdut.bbs.util;

import org.junit.Test;

public class LogTest {

    @Test
    public void test(){
        LogUtil.newLog();
        LogUtil.log("123");
        LogUtil.endLog();
    }
}
