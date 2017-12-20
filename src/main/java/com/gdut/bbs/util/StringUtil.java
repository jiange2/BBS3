package com.gdut.bbs.util;

import org.junit.Test;

public class StringUtil {

    public static int getRichTextLength(String text){
        return text.replaceAll("<(/?)(.+?)>","").length();
    }
}
