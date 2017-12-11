package com.gdut.bbs.util;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.junit.Test;

public class XssUtil {

    public static Whitelist whitelist = Whitelist.relaxed();

    static {
        whitelist.addAttributes("ol","style");
        whitelist.addAttributes("u","style");
        whitelist.addAttributes("li","style");
        whitelist.addAttributes("p","style");
        whitelist.addAttributes("table","class");
        whitelist.addAttributes("font","face");
        whitelist.addAttributes("font","src");
        whitelist.addAttributes("img","src");
        whitelist.removeProtocols("img","src","http", "https");
        whitelist.addAttributes("iframe","src","allowfullscreen","webkitallowfullscreen","mozallowfullscreen");
        whitelist.addProtocols("iframe","src","//player.youku.com","http://v.qq.com/iframe/player.html");
    }

    public static String cleanTag(String text){
        return Jsoup.clean(text,whitelist);
    }

    public static String cleanAll(String text){
        return text.replaceAll("<","&lt;").replaceAll(">","&gt;");
    }

}
